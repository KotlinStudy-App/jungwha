# 클래스
```Kotlin
class 클래스명 {
  init{
  }
  var variable:String = "" //변수(프로퍼티)
  fun function(){ //함수(메서드)
    var variable_local = ""
  }
}
```
### 초기화하여 사용하기
#### 인스턴스
##### 메모리에 로드되에 있는 클래스
```Kotlin
var cls = 클래스명()
````
#### 변수 사용
```Kotlin
cls.variable
```
#### 함수 사용
```Kotlin
cls.function()
```

### 초기화 없이 사용하기
#### companion object
``` Kotlin
class 클래스명{
  companion object{
  //클래스 내용
    }
  }
```
## 상속
### open
##### 상속 가능한 class or 재정의할수 있는 변수
 
```Kotlin 
open class Parent{
  var money = 50000
  open var house = "강남 200평 아파트"
  open fun showhouse(){
    //함수내용
    }
  }
```

### override
```Kotlin
class Child:Parent(){ //상속
  override var house = "강남 10평 오피스텔" //재정의
  override fun showhouse(){
    //함수내용
    }
  }
```

### 오버로드
##### 한 class 안에 동일한 함수 만들기
```Kotlin
class Son{
  fun getnumber():Int{
      return 1
    }
  
  fun getnumber(param:String):Int{
      return 2
    }
  }
```

# null
## null 해결법
#### 1. nullable
```Kotlin
var number : Int? = null
```
#### 2. Safe Call
##### ?를 통해 뒤를 실행하지 않게함
```Kotlin
var result = number?.plus(37)
```
#### 3. Elvis Expression
##### number가 null 일 경우에는 , result 에 57을 넣어라
```Kotlin
var result = number?.plus(37) ?: 57
var result = result.plus(53) //오류X
```
