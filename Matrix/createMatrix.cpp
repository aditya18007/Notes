#include<iostream>
#include<vector>
using namespace std;

void printMatrix(vector<vector<int>>& M){
    for(vector<int> V : M){
        for(int x : V){
            cout << x << " ";
        }
        cout << endl;
    }
}

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
    printMatrix(vec);
}
