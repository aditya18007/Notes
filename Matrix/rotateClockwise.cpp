#include<iostream>
#include<vector>
#include<assert.h>

using namespace std;

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
    

    rotate(M, left+1, right-1, top+1, bottom-1);
}
 
void print(vector<vector<int>>& M){
    for(vector<int> V: M){
        for(int x : V){
            cout << x << " ";
        }
        cout << "\n";
    }
    cout << endl;
}

int main(){
    vector<vector<int>> M {
                           {1, 2, 3, 4},    
                           {5, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13, 14, 15, 16}
    };
    int left = 0;
    int right = M[0].size()-1;
    int top = 0;
    int bottom = M.size()-1;
    print(M);
    rotate(M,left,right,top,bottom);
    print(M);
}
