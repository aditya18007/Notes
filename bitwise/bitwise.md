# Bit wise algorithms

## NOTE

|  `n`  | `n-1` | `...` |  `2`  |  `1`  |  `0`  |
| :---: | :---: | :---: | :---: | :---: | :---: |
| `1/0` | `1/0` | `...` | `1/0` | `1/0` | `1/0` |

* Left most bit is least significant.
* Position is `0`-indexed

## Operations

#### NOT

* Take a number and invert all its bits.

* The result is to be used carefully. For example,

  * ```c++
    int x = 1;
    unsigned int y = ~x;
    int z = ~y;
    
    cout << x << endl;
    cout << y << endl;
    cout << z << endl;
    ```

  * ```
    Output of above
    1
    4294967294
    -2
    ```

    

#### AND

|  Operation  | result |
| :---------: | ------ |
| `1` `&` `1` | `1`    |
| `1` `&` `0` | `0`    |
| `0` `&` `1` | `0`    |
| `0` `&` `0` | `0`    |

 

#### OR

|  Operation   | result |
| :----------: | :----: |
| `1` `|` `1`  |  `1`   |
| `1` `|` `0`  |  `1`   |
| `0` `|` `1`  |  `1`   |
| `0`  `|` `0` |  `0`   |



#### XOR

|  Operation  | result |
| :---------: | ------ |
| `1` `^` `1` | `0`    |
| `1` `^` `0` | `1`    |
| `0` `^` `1` | `1`    |
| `0` `^` `0` | `0`    |

* It is the most used one.
* Property that same bits are 0 (gets neutralised) can be exploited when we have to find something unique.

#### LEFT SHIFT

* `d<<n` 
* left shift the bits of `d` by `n`.
* Left most bit index is `0` .
* `1 << 0 == 1`
* `1 << 1 == 2` 
* Equivalent to multiplying a number by `2^n`.
* When `d<0`, behaviour is undefined.
* `n <= sizeof(d)*8`

#### RIGHT SHIFT	

* `d >> n`
* right shift the bits of `d` by `n`.
* Equivalent to dividing the number by 2^n^.
* When `d<0` , behaviour is undefined.
* `n<=  sizeof(d)*8`

## Standard Stuff

Following are the absolute basic stuff needed for manipulating.

### Binary Representation of integer

Idea is as follows:

* Check the `LSB`.
* If `d` is even, `LSB` is `0`. Otherwise, `1`.
* Right shift the number to move the next bit to `LSB` .
* Repeat while the number is `d > 0` 

```c++
stringstream ss;
do{
    if(n%2 == 1){
        ss << 1;
    } else {
        ss << 0;
    }
    n = n >> 1;
} while(n > 0);
string y = ss.str();
string z(y.rbegin(),y.rend());
cout <<  z << endl;
```



### How to set n^th^ bit ?

* `1 | x = 1 `         ..(1)
* `0|x = x`         ..(2)

We have to make the `n^{th}` bit 1 (using 1) and leave others unaffected (using 2).

0000...1~n~...00

`d = d | (1 << n)`

```c++
void set(int& d , unsigned int n){
	d = d | (1 << n);
}
```

### How to reset n^th^ bit? 

* `1&x = x`              ..(1)
* `0&x=0`               ..(2)

We have to set `n_{th}` bit 0 (using 2) and leave others unaffected (using 1).

1111...0~n~...11

`d = d & (~ (1 << n))`

```c++
void reset(int& d , unsigned int n){
	d = d & (~(1 << n))
}
```

### Toggling a bit at n^th^ position.

* `1` ^ 1 = `0`;
* `0` ^ 1 = `1`;

`Xor` with `1` toggles a bit.

To let others remain unaffected

* `1` ^ 0 = `1`;
* `0` ^ 0 = `0`;

`d = d ^ (1 << n)`

### Negative numbers

#### One's compliment 

* This is ==not== the representation, most likely.
* one's compliment = `~ d`.

#### Two's compliment

* ==This is== the representation of negative numbers, most likely.
* two's compliment = `-d`.

==Two's compliment = One's compliment + 1==



