# Standard C++ Library

## Data Structures

### `stringstream`

* Handy when size of string is not defined and you want to add objects (strings, chars, int, doubles etc.) with code to a string.

#### #include

```c++
#include<sstream>
```

#### Constructor

```c++
#include<sstream>

using namespace std;

int
main()
{
	stringstream ss1; //Default. Empty String stream
	stringstream ss2;(str) // Stringstream initialized to a string
}
```

#### Methods

##### `str()`

* Set string or get string value of stream.

* ```c++
  stringstream ss(str);
  ```

* ```c++
  std::cout << ss.str();
  ```

##### `clear()`

* Clear contents of the stream.

* ```c++
  ss.clear()
  ```

##### `>>`

* `ss >> object​`

* Open side can be thought of as reading from and pointed side as writing to.

* Put contents of stream to an object.

* ```
  string num = "12345";
  stringstream ss(num);
  int n;
  ss >> n;
  ```

##### `<<`

* `ss << object​`

* Put contents of an object to stream.

* Open side can be thought of as reading from and pointed side as writing to.

* ```c++
  stringstream ss;
  ss << 12;
  ```

### `std::bitset`

* Bitset is a `bool` array ==whose size must be known at compile time==.
* It is optimised in such a way that each `bool` value takes only a bit.   
* ==`0`-based indexing starts from left side. Left most bit is LSB.== 

#### #include

```c++
#include<bitset>
```

#### Constructor

```c++
unsigned int M = 32;
int d = 0;
string s("111000");
bitset<M> set(d);
bitset<6> set2(s);
```

* Create bitset of size `M` ==whose value must be known at compile time==.
* This set will contain binary representation of the integer d; 
* String can also be used.

#### Methods

##### Convert to integer / `to_ulong` / `to_ullong`

```c++
long l = 456789543;
int i = -33879;
bitset<32> b_i(i);
bitset<64> b_l(l);

int changed_i = static_cast<int>(b_i.to_ulong());
long changed_l = static_cast<long>(b_l.to_ullong());
```

##### `[]`

* Can be Indexed just like an array.
* ==`0`-based indexing starts from left side. Left most bit is LSB.== 

##### Logical operations

See [here](bitwise/doc.md) for more.

* Negation `~`inverts bits of the set.
* Left shift `<<` and right shift `>>` are supported.
* All binary operations `And`,`Or`,`Xor` work if ==size of both sets is same==.

##### `size()`

* Returns total number of bits in the bitset.

##### `count()`

* Returns the total number of set (`1`) bits in the set

##### `flip()`/`flip(int n)`

* ==Returns the new set==
* `flip()` flips all the bits in the set.
* `flip(int n)` flips the n^th^ bit.

##### `none()`

* returns true of no bit is set.

##### `all()`

* returns true if all bits are set.

##### `any()`

* returns true if at least one bit is set.

##### `test(int n)`

* returns true if n^th^ bit is set.

##### `set()` / `set(int n)`

* `set()` sets all bits to 1.
* `set(int n)` sets n^th^ bit to 1​.

##### `reset()` / `reset(int n)`

* `reset()` sets all bits to 0​.
* `reset(int n)` sets n^th^ bit to 0​.

### `std::map`

Dictionary. Equivalent to Java `HashMap` .

#### #include

```c++
#include <map> 
  
using namespace std; 

```

#### Constructor

Creating an empty map.

```c++
map<int,int> Map;
```

#### Methods

##### Put a `(key,value)`

```c++
Map[key] = value;
```

##### Check if a key exists

* We have to use `Map.find(key)`

```c++
if(Map.find(key) == Map.end()){
	// Key not present
} else {
	// KEy present
}
```

##### Iterating over `(Key,Value)`

###### Using iterator

```c++
#include <iterator> 
#include <map>

map<string, int>::iterator it;

for ( it = symbolTable.begin(); it != symbolTable.end(); it++ )
{
    std::cout << it->first  // string (key)
              << ':'
              << it->second   // string's value 
              << std::endl ;
}

```

###### With *C++11* ( and on wards )

```c++
for (auto const& x : symbolTable)
{
    std::cout << x.first  // string (key)
              << ':' 
              << x.second // string's value 
              << std::endl ;
}
```

###### With C++17 (and on wards)

```c++
for( auto const& [key, val] : symbolTable )
{
    std::cout << key         // string (key)
              << ':'  
              << val        // string's value
              << std::endl ;
}
```

### `std::set`

* Ordered set of elements.
* Equivalent to Java `TreeSet`.