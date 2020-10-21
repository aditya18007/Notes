# Matrix

Following explores the use of `mxn` matrices in `C++`.

## Creation

####  Note

We cannot use `2d​` `C-style` array if we don't know what will be the second dimension at compile time.

* The compiler does something like this.
  * Suppose we have an  `m x n`  matrix, `P`
    `P[i][j] = *(P + n*i + j)` 
* This is because we don't actually have $2d$ memory.

* The compiler creates `n` arrays of length`m`.

Therefore, we will use vectors.

#### Method-1 

```c++
#include<iostream>
#include<vector>
using namespace std;


int main(){
    int n,m;
    cout << "Enter number of rows : ";
    cin >> n;

    cout << "Enter number of columns : ";
    cin >> m; 
    vector<vector<int>> vec( n , vector<int> (m,0));
    return 0;
}
```

#### Method-2 

```c++
int main(){
    int n,m;
    cout << "Enter number of rows : ";
    cin >> n;

    cout << "Enter number of columns : ";
    cin >> m; 
    vector<vector<int> > vec(n);
	for(int i= 0 ; i < n ; i++){
   		vec[i] = vector<int> (m,0); 
	}
    return 0;
}
```

## Passing to a function

* As noted above, we cannot pass `C-style` arrays unless we know the second-dimension.

```
void printMatrix(vector<vector<int>>& M){
    for(vector<int> V : M){
        for(int x : V){
            cout << x << " ";
        }
        cout << endl;
    }
}
```

## Rotations

### Rotate a matrix clockwise

| **prev** | **prev** | **prev** | **prev** | **prev** | **prev** |
| :------: | :------: | :------: | :------: | :------: | :------: |
| **prev** |  x `>`   |  x `>`   |  x `>`   |  x `V`   | **prev** |
| **prev** |  `^` x   | **next** | **next** |  x `V`   | **prev** |
| **prev** |  `^` x   | **next** | **next** |  x `V`   | **prev** |
| **prev** |  `^` x   |  `<` x   |  `<` x   |  `<` x   | **prev** |
| **prev** | **prev** | **prev** | **prev** | **prev** | **prev** |

* Idea is to move around the matrix in square rings.
* `prev` above shows previous ring, which is processed.
* `X` shows the current ring which is being processed.
  * `arrow` along with `X` show the direction in which current position moves.
* `next` shows the next ring which will be processed.

Ring can be identified by four indices:

* `left` : left most column of ring.
* `right`: right most column of ring.
* `top`: top most column of ring.
* `bottom`: lowest column of ring.

Suppose the matrix is `m x n` matrix `M`.

Here is how we traverse rings

```c++
void rotate(vector<vector<int>>& M, int left, int right, int top, int bottom){
    /*
     Left to right (columns)
     Top to Bottom (rows)
     Right to Left (columns)
     Bottom to Top (rows)
     */
 	if(right <= left || bottom <= top){
        return;
    }
	//Processing   
    rotate(M, left+1, right-1, top+1, bottom-1);
}
```

Processing: 

* Start from `M[top][left]`. Store its value in `prev`.
* Move all the way till `M[top][right]`, setting `prev` value here and updating `prev`.
* Likewise, Go from `M[top][right]` -> `M[bottom][right]`-> `M[bottom][left]` -> `M[top][left]` .

```c++
int prev = -1;;

prev = M[top][left];

for(int c = left+1; c <= right ; c++){
    int curr = M[top][c];
    M[top][c] = prev;
    prev = curr;
}


for(int r  = top+1; r <= bottom ; r++){
    int curr = M[r][right];
    M[r][right] = prev;
    prev = curr; 
}


for(int c = right-1; c >= left ; c--){
    int curr = M[bottom][c];
    M[bottom][c] = prev;
    prev = curr;
}


for(int r = bottom-1; r >= top ; r--){
    int curr = M[r][left];
    M[r][left] = prev;
    prev = curr;
}
```

