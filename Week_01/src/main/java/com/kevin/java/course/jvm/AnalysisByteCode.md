[Hello.java](./Hello.java)
反编译后字节码如下：
```
Classfile /JAVA-01/Week_01/src/main/java/com/kevin/java/course/jvm/Hello.class
  Last modified 2021年1月15日; size 734 bytes
  SHA-256 checksum b6c2716a83a9e4aa82d5af9057330c1559cf4b6acd9ce8a29dda907f9b013306
  Compiled from "Hello.java"
public class com.kevin.java.course.jvm.Hello
  minor version: 0
  major version: 52
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #4                          // com/kevin/java/course/jvm/Hello
  super_class: #5                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #5.#33         // java/lang/Object."<init>":()V
   #2 = Double             5.0d
   #4 = Class              #34            // com/kevin/java/course/jvm/Hello
   #5 = Class              #35            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               LocalVariableTable
  #11 = Utf8               this
  #12 = Utf8               Lcom/kevin/java/course/jvm/Hello;
  #13 = Utf8               main
  #14 = Utf8               ([Ljava/lang/String;)V
  #15 = Utf8               i
  #16 = Utf8               I
  #17 = Utf8               args
  #18 = Utf8               [Ljava/lang/String;
  #19 = Utf8               a
  #20 = Utf8               b
  #21 = Utf8               c
  #22 = Utf8               D
  #23 = Utf8               flag
  #24 = Utf8               Z
  #25 = Utf8               sum
  #26 = Utf8               sub
  #27 = Utf8               mul
  #28 = Utf8               div
  #29 = Utf8               StackMapTable
  #30 = Class              #18            // "[Ljava/lang/String;"
  #31 = Utf8               SourceFile
  #32 = Utf8               Hello.java
  #33 = NameAndType        #6:#7          // "<init>":()V
  #34 = Utf8               com/kevin/java/course/jvm/Hello
  #35 = Utf8               java/lang/Object
{
  public com.kevin.java.course.jvm.Hello();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0                                                                       // 对象 this 的引用押入栈
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V     // 调用父类（Object）的构造方法
         4: return
      LineNumberTable:
        line 6: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/kevin/java/course/jvm/Hello;                     // 非静态的方法，默认0槽位的参数为this

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=11, args_size=1
         0: iconst_2                          // int 2 押入栈顶
         1: istore_1                          // 栈顶int类型 a=2 存入第二个本地变量
         2: iconst_1                          // int 1 入栈
         3: istore_2                          // 栈顶int类型 b=1 存入第三个本地变量
         4: ldc2_w        #2                  // double 5.0d 将（double）5.0d 从常量池中推送至栈顶
         7: dstore_3                          // 栈顶的double类型 存入 第4个本地变量
         8: iconst_1
         9: istore        5                   // 第6个本地变量存入 flag = 1 (true)
        11: iload_1                           // 载入 a
        12: iload_2                           // 载入 b
        13: iadd
        14: istore        6                   // a + b的结果sum存入 第7个本地变量
        16: iload_1
        17: iload_2
        18: isub
        19: istore        7                   // a - b = sub ==> slot 7
        21: iload_1
        22: iload_2
        23: imul
        24: istore        8                   // a * b = mul ==> slot 8
        26: iconst_0
        27: istore        9                   // int div = 0
        29: iload_2                           // b 推入 栈顶
        30: ifeq          43                  // b == 0 时跳转到 43 处
        33: iload         5
        35: ifeq          43                  // if flag == 0（false）则跳到43
        38: iload_1
        39: iload_2
        40: idiv
        41: istore        9                   // a / b = div ==> slot 9
        43: iconst_0
        44: istore        10                  // i = 0
        46: iload         10                  // i
        48: iconst_5                          // 5 入栈
        49: if_icmpge     62                  // if i >= 5 则 跳到62
        52: dload_3                           // c
        53: dconst_1                          // 1.0d
        54: dadd                              // c + 1.0d
        55: dstore_3                          // 存入 slot 3 （c）
        56: iinc          10, 1               // i++
        59: goto          46                  // 跳转到46，继续循环
        62: return
      LineNumberTable:
        line 9: 0
        line 10: 2
        line 11: 4
        line 12: 8
        line 14: 11
        line 15: 16
        line 16: 21
        line 17: 26
        line 19: 29
        line 20: 38
        line 23: 43
        line 24: 52
        line 23: 56
        line 26: 62
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           46      16    10     i   I
            0      63     0  args   [Ljava/lang/String;
            2      61     1     a   I
            4      59     2     b   I
            8      55     3     c   D
           11      52     5  flag   Z
           16      47     6   sum   I
           21      42     7   sub   I
           26      37     8   mul   I
           29      34     9   div   I
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 43
          locals = [ class "[Ljava/lang/String;", int, int, double, int, int, int, int, int ]
          stack = []
        frame_type = 252 /* append */
          offset_delta = 2
          locals = [ int ]
        frame_type = 250 /* chop */
          offset_delta = 15
}
SourceFile: "Hello.java"
```