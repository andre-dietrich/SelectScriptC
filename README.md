# SelectScriptC

SelectScript Compiler and REPL implemented in Clojure for the SandhillSkipperVM.

SelectScript is a dynamically typed programming language with imperative,
procedural, functional, (object-oriented), declarative and relational aspects.

## Editor Integration

There is syntax highlighting support for several editors available:

| Atom  | [github.com/ESS-OVGU/language-selectscript](https://github.com/ESS-OVGU/language-selectscript) |
|-------|------------------------------------------------------------------------------------------------|
| Emacs | [github.com/fin-ger/select-script-mode](https://github.com/fin-ger/select-script-mode)         |

## Setup

### Requirements

This system was only tested on Linux and Arduino...

* git ;)
* gcc
* Java and Clojure (see: https://leiningen.org)

### Download

The following command will download the entire project:

``` bash
git clone --recursive  https://github.com/ESS-OVGU/SelectScriptC.git
```

### Build

Build the entire system, including VM with its dynamic type-system and the
language compiler. While the first two elements have been developen in plain C,
the compiler was implemented in Clojure.

``` bash
cd SelectScriptC
make
```

Run the following command to install the `S2c` to `/usr/local/bin`.

``` bash
make install
# make uninstall # for uninstalling
```

> Alternatively you can also enter `SandhillSkipper` and run make in there and
> compile the Clojure sources with `lein uberjar` or `lein run`.

### Test

All test-cases are defined in folder `test`, to run all test use the following
command:

``` bash
lein test
```

To only test a certain file use:

``` bash
lein test towers # will run all test in towers.clj
```

or to run only one specific test:

``` bash
lein test :only towers/simple
```

## Usage

### Basics

Some basic examples can be found in the corresponding folder:
``` bash
cd examples
```

To execute a SelectScript program use
``` bash
S2c -x ackerman.S2
```

Or use the interactive shell by run in `S2c` only, but there are also more
options, use `-h` or `-help` to see all:
``` bash
S2c --help
 __      _           _   __           _       _
/ _\ ___| | ___  ___| |_/ _\ ___ _ __(_)_ __ | |_
\ \ / _ \ |/ _ \/ __| __\ \ / __| '__| | '_ \| __|
_\ \  __/ |  __/ (__| |__\ \ (__| |  | | |_) | |_
\__/\___|_|\___|\___|\__\__/\___|_|  |_| .__/ \__|
                                     |_|

  -o, --output FILE    Export result to file
      --no-optimize    Do not optimize
  -d, --debug          execute stepwise
  -a, --assembly       print assembly
  -i, --interim        print interim
  -b, --bytecode       print bytecode
  -p, --parse-tree     print parsetree
  -x, --execute        Run the program
  -r, --repl           interactive
  -s, --server         run compiler as web-server
      --port           server port
  -h, --help
```

### Compilation

If only bytecode should be generated, that should be executed on another VM,
then use `-a` or `-b` and pipe the result into a target file:

``` bash
S2c -b ackerman.S2 > ackerman.h
cat ackerman.h
12, 8, 2, 0, 5, 65, 99, 107, 0, 3, 110, 0, 3, 109, 0, 6, 65, 99, 107, 40, 0, 3,
44, 0, 5, 41, 32, 61, 0, 7, 112, 114, 105, 110, 116, 0, 0, 9, 0, 90, 0, 12, 3,
3, 109, 0, 3, 110, 0, 5, 65, 99, 107, 0, 2, 0, -106, 0, 0, -106, 1, 52, 16, 0,
64, 0, 25, 11, 0, 16, 1, 3, 1, 66, 1, 26, 54, 0, 16, 1, 64, 0, 25, 21, 0, 16, 0,
3, 1, 67, 1, 3, 1, 7, 2, 0, 38, 0, 26, -44, -1, 26, 28, 0, 16, 0, 3, 1, 67, 1,
16, 0, 16, 1, 3, 1, 67, 1, 18, 2, 24, 2, 7, 2, 0, 38, 0, 26, -73, -1, 15, -108,
1, 13, 0, 3, 0, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, 3, 8, 3, 9, 7, 10, 0,
3, 0, 3, 1, 3, 2, 3, 3, 7, 4, 0, 11, 2, 0, 2, 3, 27, 0, 28, 25, 30, 0, 48, 10,
4, 16, 3, 10, 5, 16, 2, 10, 6, 16, 3, 16, 2, 18, 1, 24, 2, 18, 7, 24, 7, 36, 0,
26, -30, -1, 14, 14,
```

In contrast to this, the `-a` option will generate pretty-printed and readble
assembly-code, that can directly be applied in C. All mnemonics are C-defines
and correspond to a numerical value, as depicted in the listing above.

``` bash
S2c -a ackerman.S2 > ackerman.h
cat ackerman.h

/*0000*/ SP_SAVEX,    8, // 8
                      2, 0, //  ""
                      5, 'A', 'c', 'k', 0, //  "Ack"
                      3, 'n', 0, //  "n"
                      3, 'm', 0, //  "m"
                      6, 'A', 'c', 'k', '(', 0, //  "Ack("
                      3, ',', 0, //  ","
                      5, ')', ' ', '=', 0, //  ") ="
                      7, 'p', 'r', 'i', 'n', 't', 0, //  "print"
                      0, // local variables
/*0037*/ ENC_PROC,    0, // help: ""
                      90, 0, // length: 90
//////////////////////////////////////////////////////////
/*0040*/               SP_SAVEX,    3, // 3
                                    3, 'm', 0, //  "m"
                                    3, 'n', 0, //  "n"
                                    5, 'A', 'c', 'k', 0, //  "Ack"
                                    2, // local variables
/*0054*/               ENC_NONE,
/*0055*/               STORE_LOC|P, 0, // "m"
/*0057*/               ENC_NONE,
/*0058*/               STORE_LOC|P, 1, // "n"
/*0060*/               PROC_LOAD,
/*0061*/               LOC,         0, // "m"
. . .
```

### Debug

A SelectScript program can also be executed in Debug-mode, which executes every
command step-wise and outputs the current state of the stack and the global
memory. Use Enter to step through a program:

````bash
S2c -d ackerman.S2

 __      _           _   __           _       _
/ _\ ___| | ___  ___| |_/ _\ ___ _ __(_)_ __ | |_
\ \ / _ \ |/ _ \/ __| __\ \ / __| '__| | '_ \| __|
_\ \  __/ |  __/ (__| |__\ \ (__| |  | | |_) | |_
\__/\___|_|\___|\___|\__\__/\___|_|  |_| .__/ \__|
                                     |_|

#addr op_code   params   stack                                 memory
0000: SP_SAVEX  8        [[]]                                  {}
0037: ENC_PROC  0, 90    [[,0]]                                {}
0131: STORE|P   1        [[,0,FCT]]                            {}
0133: SP_SAVE   0        [[,0]]                                {Ack:FCT}
0135: ENC_INT1  0        [[,0,,1]]                             {Ack:FCT}
0137: ENC_INT1  1        [[,0,,1,0]]                           {Ack:FCT}
0139: ENC_INT1  2        [[,0,,1,0,1]]                         {Ack:FCT}
0141: ENC_INT1  3        [[,0,,1,0,1,2]]                       {Ack:FCT}
0143: ENC_INT1  4        [[,0,,1,0,1,2,3]]                     {Ack:FCT}
0145: ENC_INT1  5        [[,0,,1,0,1,2,3,4]]                   {Ack:FCT}
0147: ENC_INT1  6        [[,0,,1,0,1,2,3,4,5]]                 {Ack:FCT}
0149: ENC_INT1  7        [[,0,,1,0,1,2,3,4,5,6]]               {Ack:FCT}
. . .
```

## Language Basics

Every statement is closed with a semicolon; and the last statement of a script
or a sub-script defines its return value.

### Comments
```
# this is a single line comment

/*
multi-line
comment or
inner one
*/
```

### Types and Memory

Types are similar to Python-types:

``` bash
None;                       # undefined
True; False;                # boolean
123; -33333;                # Integer
0b11111; 0o112; 0xfff;      # also Interger (binary, octal, hex)
-12.3333;                   # Float
"this is a String!";
[None, 12, "str", False];   # List
{12, 0, "xxx", []};         # unordered Set
{elem: 12, "elem 2": "12"}; # Dictionary
```

There are two different types of memory that can be used (of course, as in most
other languages) a global and a local memory. Locally stored variables are
indicated by a starting `$` and are stored on the stack.

``` bash
$local_variable = None;
global_var12SD  = 12;
```

#### List Access

``` bash
a = ["a", "b", "c"];

a[0];                       # -> "a"
a[1];                       # -> "b"
a[-1];                      # -> "c"

a = a + a;                  # -> ["a", "b", "c", ["a", "b", "c"]]
a[-1,1];                    # -> "b"
a[-1][1];                   # -> "b"

a[2] = 33;
a;                          # -> ["a", "b", 33]
```

The elements of a Set can be accessed similarly.

#### Dictionary Access

Dictionaries can be defined and accessed in two ways, with strings or variable
names. By doing this, dictionaries can also be used as prototypes, which enables
object-oriented programming, similar to LUA.

``` bash
a = {elem: 12, "elem 2": "12abc"};

a.elem;         # can be used for prototypes, only var names are allowed -> 12
a["elem 2"];    # string identifiers with spaces -> "12abc"

a["var33"] = "rock";
a.var44 = "rock too";

a.var33;        # -> "rock"
a["var44"];     # -> "rock too"
```


### Operators

Also the operators are "nearly similar" to the ones in Python and the result is
defined by the highes data-type:

``` bash
True AND False OR True;     # boolean -> True

22 * 3 + 0.1;               # float   -> 66.099998
22 *(3 + 0.1);              # float   -> 68.199996

"string " + 222;            # string  -> "string 222"
222 + " string";            # string  -> "222 string"
```

The last expression in the listing above would cause an error in Python, but not
in SelectScript. The result is also a string, but with the number added to the
front. This behavoir is similar to lists and sets.

``` bash
[1,2,3] + "string";        # list  -> [1,2,3,"string"]
0 + [1,2,3];               # list  -> [0,1,2,3]

2 * [1,2,3];               # list  -> [1,2,3,1,2,3]

{1,2,3} + 3 + 3 + 4;       # set   -> {1,4,2,3}
{1,2,"str"} - "str";       # set   -> {1,2}

[1,2,3] - 22;              # Error: 11 -> operation not permitted
```

SelectScript uses a three-valued-logic, which means, if a logical operation or
comparison might make no sense, it is evaluated to `None`, which simply means
unknow and which is treated as logical false. One reason for this is, that you
do not have to cope with exceptions in this case and it still might generate a
valuable result:

``` bash
True OR (12 < "abc");      # True OR None -> True
False AND None OR True;    # (who cares) OR True -> True
NOT None;                  # is still -> None
```

You can use arithmetic (including power), logical (including XOR), comparison,
and bit- operators, see `test/ops.clj` for all supported operators and their
intended behavior.

### Operators as Functions

Operators are internaly applied similar to a function, that means, see the
following expression:

``` bash
1 + 2 + [] + 3;            # [3,3]
+(1,2,[],3);               # [3,3]
```

Both expressions are syntactically equivalent, and both generate the same opcode
(`OP|ADD 3`), which results in reduced bytecode and a faster execution. The
following expressions are also equivalent:

``` bash
1 < 2 < -3 < 4 < 5 < 99 < 333;  # False, because of -3
<(1, 2, -3, 4, 5, 99, 333);     # also False
```

The opcode is `OP|LT 6`, if the optimization by the compiler is disabled, due to
the `--no-optimize` parameter, the VM would stop at `-3` and return the value
`False` without checking the other values.

### Special Operators

#### List Asterisk

For lists, a special asterisk operator is defined, which mean, extract all
values within the list and apply the operation:

``` bash
list = [1,2,3,4,5,6,7,8];
<(*list);                       # True
<(-99, *list, 99);              # True
<( 99, *list, 99);              # False

+(*list);                       # 55
```

#### The @ operator

To all functions and operators an `@` can be prepend:

``` bash
a = 0;

a@+(1);                         # 1
a@+(1);                         # 2
a@+(1);                         # 3
a@+(-1);                        # 2

# same same but different
a = a + 1;

a = [0,1,2,3];

a@+(4);                         # [0,1,2,3,4]
a@+(5);                         # [0,1,2,3,4,5]
a@+(6);                         # [0,1,2,3,4,5,6]
a@+(None);                      # [0,1,2,3,4,5,6,]
```

The `@` indicates that the operation is directly applied in memory, without the
need of generating a new 'list' on the stack and then copy it to the global
memory by deleting the previous value.


### Scopes

Sub-procedures can simply be put into braces:

``` bash
a = ( $a = 2; $b = 99; $a * $b; );  # 198
```

The local variables `$a` and `$b` only exist within the parenthis. Such
parenthis can also be nested.

### IF/Else

As it is common for functional programming, an if statement is more like a
special function that returns a value:

``` bash
a = IF( True, 99, ($a = 122; $a + "the false part is not evaluated";) );  # 99
```

But you could also write it as:

``` bash
IF( True,
    a = 99,
    a = ($a = 122; $a + "the false part is not evaluated";) );  # 99
```

The global variable `a` would store in both cases `99`, but try to use the more
elegant first (functional) style.

### LOOP and EXIT

Every statement returns a value, for loops this can be tricky. If loops should
be used to define some non-linear behavior, then use the following syntax:

``` bash
end = 99;
i   = 1;
a   = LOOP ( IF(i > end, EXIT i, i = i * 2); );  # 128

# will also store 128 in global a
LOOP ( IF(i > end, (a = i; EXIT None;), i = i * 2); );
```

Thus, a loop is somehow a special kind of a function that returns the value that
is followed by the `EXIT` command.

### Try Catch

``` bash
try( var < 222, "var is undefined");  # -> "var is undefined"

var = 12;

try( var < 222, "var is undefined");  # -> True
```

### Procedures

Functions can either be defined as external C functions and added to the VM or
defined within SelectScript. The purpose of defining C functions is that they
can run faster and provide an interface to the external periphery.

#### Integrating C Functions

``` c
trilian analogRead ( dyn_c * rslt , dyn_c param [] , ss_byte len )
{
    dyn_free ( rslt ) ; // free rslt and set it to None
    switch ( len ) {
        case 2: if ( DYN_TYPE (& param [1]) <= FLOAT && DYN_TYPE (& param [1]) )
                    analogReadResolution ( dyn_get_int (& param [1]) ) ;
                else return VM_ERROR ;
        case 1: if ( DYN_TYPE (& param [0]) <= FLOAT && DYN_TYPE (& param [0]) )
                    dyn_set_int ( rslt , analogRead ( dyn_get_int ( param ) ) ;
                else return VM_ERROR ;
    }
    return DYN_OK ;
};

...
// attaching the function to the VM goes like this ...
vm_add_function(env,          // vm
                "analogRead", // internal name
                analogRead,   // function pointer
                "analogRead( pin (, resolution) ?) ;" ) ; // help string

```

This function can afterwards be called from within the VM with `analogRead`

``` bash
sensorValue = analogRead(13);
```

#### Internal Functions

There are already a couple of functions predifined to the VM, these functions
can be searched with the following function:

``` bash
help();
# ["help", "mem", "del", "print", "size", "float", "str", "int", "type", "len",
#  "time", "none?", "bool?", "int?", "float?", "str?", "list?", "dict?", "proc?",
#  "ex?", "insert", "remove", "pop", "hash"]
```

It returns a list of all defined functions. If you want some help on a certain
function, then use:

``` bash
help("function-name");
```

This will return the defined help-string.

``` bash
mem();            # return list with global variables
$x = del(var);    # delete global variable and return its value

len([1,2,3,4,5]); # -> 5
len("1234567");   # -> 7
len(...)

a = [1,2,3,4];
a@insert(33, 2);  # -> [1,2,33,3,4]
a@pop();          # -> [1,2,33,3]
a@remove(2);      # -> [1,2,3]

str(a);           # -> "[1,2,3]"

none?(a);         # -> False
list?(a);         # -> True

a = print("log", 22+1); # prints out log 23 and return the value 23
```


#### Procedures

A Procedure in SelectScript can be defined with the keyword `PROC` or
`PROCEDURE`.

``` bash
p = PROC() "insert help here" : ($a=12; 22*12;);

help(p);    # -> "insert help here"

p2 = p;     # copy procedures and pass them like values

p2();       # execute the function -> 264
```

The help-string is only optional. Procedures with parameters are defined as
followes. Note that they are accessed from within as local variables:

``` bash
fak = PROC(x): if($x, $x*fak($x - 1), 1);

fak(0);           # -> 1
fak(1);           # -> 1
fak(2);           # -> 2
fak(3);           # -> 6
fak(4);           # -> 24
fak(5);           # -> 120
fak(6);           # -> 720
```

Functions can have optional parameters, which are set by an additionl colon:

``` bash
add = PROC(a, b:12): $a + $b;

add(1,2);         # -> 3
fak(1);           # -> 13
```

#### Tail-Recursion

Tail-recursion can be defined by the keyword recur, which means, that this
function not called recursively, but instead the local values are set to the
new values and some kind of goto to the function start is performed. Thus, no
stack-frame is added, which results in a smaller memory footprint.

``` bash
fak2 = proc(x, rslt:1) : IF ($x, recur($x-1, $rslt*$x), $rslt);

fak2(0);          # -> 1
fak2(1);          # -> 1
fak2(2);          # -> 2
fak2(3);          # -> 6
fak2(4);          # -> 24
fak2(5);          # -> 120
fak2(6);          # -> 720
```

#### Pipes

A pipe operator can be used to simplify nested functions, both expressions are
equivalent:

``` bash
c(b(a(12, x)));

x |> a(12) |> b() |> c();
```


### Selects

Select-Statements can be use in many ways... one of the many benefits is, that
it can be used similar to map/reduce/filter, for analyzing any kind of data:

```bash

dist = [10.1,11.3,10.9,11.2,15.4,11.5,10.6,12.7,12.8];

Filter = FROM dist WHERE $ > 12;
# -> [15.399999 12.699999 12.8]

Map = SELECT int($) FROM dist;
# -> [10 11 10 11 15 11 10 12 12]

MapEx = SELECT try( ($[-1]$ + $ + $[1]$) / 3.0, None )
          FROM dist;
# -> [nil 10.766667 11.133334 12.5 12.699999 12.5 11.599999 12.033332 nil]

Reduce = (SELECT $sum@+($) FROM dist
      START WITH $sum=0
              AS void) / len(dist);
# -> 11.833333
```

Please see file `test/select.clj` for some more expressive examples.
Select-Statements can be applied onto everything in SelectScript and differ from
common SQL, we applied only the basic syntax but use it differently.

For example the keyword `AS` can be followed by:

* `void`: perform only the calculation
* `value`: return the first value and discard the results
* `list`: generate a list
* `set`: generate a set
* `dict`: generate a dictionary

Thereby lists and sets can be associated with simple columns, while dictionaries
represent entire databases:

``` bash
a = [0,1,2,3,4];

c = SELECT $a, $b
      FROM a, b:a
        AS dict;
# {"a": [0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4],
#  "b": [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4]}

d = SELECT r1:$a, r2:$b, prod:($a*$b)
      FROM a, b:a
     WHERE $a * $b > 0
        AS dict;

# {"r1":   [ 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4],
#  "r2":   [ 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4],
#  "prod": [ 1, 2, 3, 4, 2, 4, 6, 8, 3, 6, 9,12, 4, 8,12,16]}
```

Also here the `$` notation is used to access the elements of a query, a simple
`$` without a variable name attached will always return refer to the first row.

### Solving Riddles

An extended recursive notation can be used to solve reasoning problems, such as
the towers of hanoi, see therefor also `examples/towers_of_hanoi.S2`:

``` bash
mov
  = PROC(Tower, frm, to)
    "A simple tower move function that returns a new tower configuration:
     mov([[3,2,1], [], []], 0, 1) -> [[3,2], [1], []]

     In case of an unalowed move a None value gets returned:
     mov([[3,2], [1], []], 0, 1)  -> None "
    : ( IF( $Tower == None, EXIT None);

        IF( not $Tower[$frm], EXIT None);

        IF( $Tower[$to],
            IF( $Tower[$frm][-1] > $Tower[$to][-1],
                EXIT None));

        $Tower[$to]@+( $Tower[$frm][-1] );
        $Tower[$frm]@pop();
        $Tower;
      );


# initial tower configuration
tower = [[3,2,1], [], []];

# allowed moves [from, to]
moves = [[0,1], [0,2], [1,0], [1,2], [2,0], [2,1]];

# goal configuration
finish = [[], [], [3,2,1]];

    SELECT $tower
      FROM m:moves
     WHERE finish == mov($tower, $m[0], $m[1])
START WITH $tower = tower
CONNECT BY NO CYCLE
           $tower@mov($m[0], $m[1])
 STOP WITH $tower == None OR $step$ > 6
        AS LIST;
```

And the result is the configuration of the towers from start, to ... one before
the end.

```
[[[[3,2,1],[],[]],
 [[3,2],[],[1]],
 [[3],[2],[1]],
 [[3],[2,1],[]],
 [[],[2,1],[3]],
 [[1],[2],[3]],
 [[1],[],[3,2]]]]
```
