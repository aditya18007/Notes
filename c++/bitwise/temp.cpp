#include <iostream>
#include <bitset>

using namespace std;

int
main()
{
    
    long l = 456789543;
    int i =-33879;
    bitset<32> b_i(i);
    bitset<64> b_l(l);

    int changed_i = static_cast<int>(b_i.to_ulong());
    long changed_l = static_cast<long>(b_l.to_ullong());
    cout << "Original i = " << i << endl << "Bitset  = " << b_i << endl << "value = " << changed_i << endl << endl;
    cout << "Original l = " << l << endl << "Bitset  = " << b_l << endl << "value = " << changed_l << endl << endl;
}
