# Matrix

Following explores the use of `mxn` matrices in `C++`.

## Creation

####  Note

We cannot use `2d​` `C-style` array if we don't know what will be the second dimension at compile time.
$$
\textrm{Suppose we have an } m \times n \textrm{ matrix,} \theta \\
\theta[i][j] = *(\theta + n \times i + j)
$$
The compiler does something like this. This is because we don't actually have $2d$ memory.

* The compiler creates `n` arrays of length`m`.
* Therefore, we will use vectors.

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

