# 배열

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


# 반복문, 조건문

## for
```Kotlin
for(index in 1..10){
//코드내용
}
```

### until
##### 마지막값 제외
```Kotlin
for(index in 1 until 10){
//코드내용
}
```
### step
##### 건너뛰기
```Kotlin
for (index in 1 until 10 step 2){
//코드내용
}
```

### downTo
##### 거꾸로
```Kotlin
for (index in 10 downTo 1){
//코드내용
}
```

### control loop
```Kotlin
for(index in 1..10){
//코드내용
} break //혹은 continue
```


## while
```Kotlin
while(//조건){
//코드내용
}
```

## do while
#### 코드내용을 한번 실행 후 반복할지 조건으로 결정
```Kotlin
do{
//코드내용
}while(//조건)
```

# 함수
#### 입력값 타입 명시, return값 타입 명시
```Kotlin
fun function(param1:String, param2:Int):Double{
//코드내용
return 3.14}
```
