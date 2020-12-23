## 배열

```Kotlin
var intArray:IntArray = IntArray(10)
intArray[0] = 0
intArray[1] = 10
intArray[2] = 20
intArray[3] = 30
```
### 한번에 생성하기

```Kotlin
var intArray = intArrayOf(0,10,20,30)
```

## 컬렉션
##### 크기가 정해져 있지 않다.
```Kotlin
var mutablelist = mutablelistOf<Int>()
```

##### add로 값 넣기
```Kotlin
mutablelist.add(5)
mutablelist.add(63)
```


## 맵 (key, value)
```Kotlin
var mutableMap = mutableMapOf<String, String>()
```
##### put으로 값 넣기
```Kotlin
mutableMap.put("변수1", "값1")
mutableMap.put("변수2", "값2")
```
