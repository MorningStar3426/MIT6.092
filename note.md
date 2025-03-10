# Lecture 1
String in Java:  
```
text = text + " number " + 5;
// text = "hello world number 5
```
# Lecture 2
## Notes
Type：  
``double d = 5/2; // d = 2.0``  
int 和 double 之间有一个强制转换  

**Do NOT call == on doubles! EVER.**  
```java
double a = Math.cos (Math.PI / 2);
double b = 0.0;
```
```
a = 6.123233995736766E-17
a == b will return FALSE
```
## Problem
What is the question in the following program?  
```java
public class Scope {
    public static void main(String[] arguments){
        int x = 5;
        if (x == 5){
            int x = 6;
            int y = 72;
            System.out.println("x = " + x + " y = " + y);
        }
        System.out.println("x = " + x + " y = " + y);
    }
}
```
**解释**：  
1. 变量重复定义错误  
在 if 块中，变量 x 被重新定义为 int x = 6。然而，这与外部的变量 x 产生了冲突。  
Java 中不允许在同一个作用域内重新定义同名的变量。因此，编译器会报错，指出变量 x 已经被定义。
2. 变量 y 的作用域问题  
变量 y 在 if 块中定义，其作用域仅限于该 if 块内部。在 if 块外部，变量 y 是不可见的。  
因此，当程序尝试在 if 块外部打印 y 时，编译器会报错，指出变量 y 未定义。
# Lecture 4
## 静态方法与实例方法的区别
**核心区别：归属和访问**
* **归属：**
    * **静态方法：** 属于类本身。它们不依赖于类的任何特定实例（对象）。
    * **实例方法：** 属于类的实例（对象）。它们必须通过类的实例来调用。
* **访问：**
    * **静态方法：**
        * 只能直接访问类的静态成员（静态变量和静态方法）。
        * 不能直接访问实例成员（实例变量和实例方法）。如果需要访问实例成员，必须通过对象引用。
    * **实例方法：**
        * 可以访问类的所有成员，包括静态成员和实例成员。

**具体区别**

1.  **调用方式：**
    * **静态方法：** 可以直接通过类名调用，例如：`ClassName.staticMethod();`
    * **实例方法：** 必须通过类的实例（对象）调用，例如：`objectName.instanceMethod();`
2.  **`this` 关键字：**
    * **静态方法：** 没有 `this` 关键字。因为它们不属于任何特定对象。
    * **实例方法：** 有 `this` 关键字。`this` 关键字指向调用该方法的当前对象。
3.  **内存分配：**
    * **静态方法：** 在类加载时分配内存。
    * **实例方法：** 在创建类的实例（对象）时分配内存。
4.  **使用场景：**
    * **静态方法：**
        * 执行与类相关的通用操作，而不是与特定对象相关的操作。
        * 创建实用工具方法，例如数学计算、字符串操作等。
        * 实现单例模式。
    * **实例方法：**
        * 访问和修改对象的状态。
        * 执行与对象行为相关的操作。

**简单示例**

```java
public class Example {

    static int staticVariable = 10;

    int instanceVariable = 20;

    // 静态方法
    public static void staticMethod() {
        System.out.println("静态变量：" + staticVariable);
        // 无法直接访问 instanceVariable
    }

    // 实例方法
    public void instanceMethod() {
        System.out.println("静态变量：" + staticVariable); // 可以访问静态变量
        System.out.println("实例变量：" + instanceVariable);
    }

    public static void main(String[] args) {
        Example.staticMethod(); // 调用静态方法

        Example example = new Example(); // 创建实例
        example.instanceMethod(); // 调用实例方法
    }
}
```

**总结**

* 静态方法是类级别的，用于执行通用操作。
* 实例方法是对象级别的，用于操作对象的状态和行为。
* 静态方法里边不存在this关键词
## 语法小知识
**案例**
```java
for (int i = 0;i < this.numOfBooks; i++){
    // 这里获取的实际上是collections里边对应元素的一个饮用
    // 对book的行为实际上是在修改 collections 列表中该位置的 Book 对象的状态。
    Book tmp = this.collections.get(i);
    if (tmp.getTitle().equals(title)){
        find = true;
        if (tmp.isBorrowed()){
            System.out.println("Sorry, this book is already borrowed.");
            break;
        }else {
            tmp.rented();
            System.out.println("You successfully borrowed " + title);
            break;
        }
    }
}
```
# Lecture 5
## ArrayList 简要笔记

### 定义
ArrayList 是 Java 中一种可修改的列表，内部通过数组实现。

### 特点
- **可修改性**：允许添加、删除和修改元素。
- **索引操作**：支持通过索引获取和设置元素。
- **动态大小**：根据需要自动调整内部数组的大小。
- **遍历**：支持通过循环遍历所有元素。

### 常用操作
- **添加元素**：使用 `add` 方法将元素添加到列表末尾。
- **访问元素**：使用 `get` 方法通过索引获取元素。
- **修改元素**：使用 `set` 方法通过索引修改元素。
- **删除元素**：使用 `remove` 方法通过索引删除元素。
- **遍历列表**：可以使用传统的 `for` 循环或增强型 `for` 循环（foreach）来遍历所有元素。

### 示例代码
```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Evan");
        strings.add("Eugene");
        strings.add("Adam");

        System.out.println(strings.size());
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));

        strings.set(0, "Goodbye");
        strings.remove(1);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
```

### 与数组的区别
与传统数组相比，ArrayList 不需要显式指定大小，且提供了更灵活的元素操作方式。例如，在数组中添加或删除元素可能需要手动处理数组的重新分配和移动元素，而 ArrayList 内部会自动处理这些操作。

# Lecture 6
## assert
`assert` 语句用于在运行时验证假设条件是否为真。如果 `assert` 语句中的条件为假（即断言失败），则程序会抛出一个 `AssertionError` 异常。

### 基本语法

```java
assert expression1 : expression2;
```

- `expression1`：要检查的条件，必须是一个布尔表达式。
- `expression2`（可选）：如果 `expression1` 为假，将被转换为字符串，并作为 `AssertionError` 异常的消息。这有助于提供更多关于断言失败的信息。

### 示例

```java
public class AssertExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        // 断言 x 小于 y
        assert x < y : "x is not less than y";

        System.out.println("Assertion passed.");
    }
}
```

在这个例子中，由于 `x < y` 为真，程序将正常运行并打印 "Assertion passed."。如果 `x` 不小于 `y`，则会抛出 `AssertionError` 异常，并显示消息 "x is not less than y"。

### 启用和禁用断言

默认情况下，Java 程序在运行时不会检查断言。要启用断言检查，需要在运行程序时使用 `-ea`（或 `--enableassertions`）选项：

```bash
java -ea AssertExample
```

要全局禁用断言（即使在编译时包含了断言），可以使用 `-da`（或 `--disableassertions`）选项：

```bash
java -da AssertExample
```

### 断言和性能

由于断言主要用于调试目的，它们可能会影响程序的性能。因此，在生产环境中，通常建议禁用断言检查，以避免性能损失。

### 注意事项

- 断言不应该用于验证正常运行时应该为真的条件，而应该用于检查程序的不变式或其他关键假设。
- 断言不应该用于替代异常处理。对于可能在正常运行时发生的异常情况，应该使用异常处理机制（如 `try-catch` 块）来处理。

## 接口
接口中的method不需要body