# 값 전달하기 
## 버튼을 누르면 SubActivity에 값 전달
#### MainActivity에서
```Kotlin
button.setOnClickListner{
  vat intent = Intent(this, SubActivity:class.java)
  intent.putExtra("param", "실제값") //전달
  stratActivityForResult(intent, 99)
  }
```
#### SubActivity 에서 
```Kotlin
val param = intent.getStringExtra("param") //전달된 값 param에 저장
Log.d("전달받은 값", "param = $param")
```



# 값 되돌려주기
## 버튼을 누르면 MainAcitiy에 값 되돌려줌
#### SubActivity에서
```Kotlin
returnvaluebutton.setOnClickLister{
  val intent = Intent()
  intent.putExtra("param2","돌려드립니다")// 되돌려주기
  setResult(Activity.RESULT_OK, intent) //정상적으로 되었다고 알려주는 코드
  finish() //subActiviy가 닫히도록
  }
```

#### MainActivity에서
```Kotlin
override fun onActivityResult(requestCode: Int, resultCode = Int, data:Intent?){
  //resultCode = 정상적일때 Activity.RESULT_OK 를받음, data = Intent 값
  if (resultCode == Activity.RESULT_OK){
    val returnvalue == data?.getStringExtra("param2") ?: "None" //data 는 Intent?이므로
    Log.d("액티비티", "돌려받은 값 = $returnvalue")
    }
  }
  ```
  # 스피너
  ```Kotlin
  val data = listOf("-선택", "월", "화", "수", "목", "금", "토", "일")
  val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
  spinner.adapter = adapter
  ```
  
  
  #### 선택한 것을 텍스트뷰에 나타내기
  ```Kotlin
  spinner.onItemSelectedListner = object: AdapterView.OnItemSelectedListner{
    override fun onItemSelected(parent: AdapterView<*>?, view : View? , position: Int, id:Long){
      val selectedValue = data[position]
      textView.text = selectedValue
    override fun onNothinSelected(parent:AdapterView<*>?){
        }
      }
    }
    ```
  
