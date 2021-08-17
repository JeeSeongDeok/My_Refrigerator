<p align=center>
<img src = "https://user-images.githubusercontent.com/23256819/127474829-1bfb391e-ad0c-4997-a0b2-1b19f43d1adf.png" width=150 height=300>
<img src = "https://user-images.githubusercontent.com/23256819/127477223-2b53cb17-4d71-4f70-a6ed-0061a1192457.png" width=150 height=300>
<img src = "https://user-images.githubusercontent.com/23256819/127477233-4b5aa818-e000-4bfb-b8a5-f600886a65a8.png" width=150 height=300>
<img src = "https://user-images.githubusercontent.com/23256819/127636659-e5cd95d4-82fe-490b-9a58-eec75c99c193.png" width=150 height=300>
<img src = "https://user-images.githubusercontent.com/23256819/127636756-eb230501-47a6-4d63-89d5-270d65215f13.png" width=150 height=300>
</p>

# My_Refrigerator
<p> K-Hackathon 공모전에 참가하기 위해서 개발한 냉장고 관리 어플리케이션이다. </p>
<p> 혼자살거나 일상이 바빠서 냉장고 관리를 제대로 하지 못하는 사람들을 위해 개발한 어플리케이션이다.</p>
<p> MVVM 아키텍처를 이용해서 유지보수가 쉽도록 만들었다.</p>

## 로그인 화면
### 코드

<p> signupActivity는 뷰 모델에 있는 live date가 변하는지 계속 확인함 </p>

```kotlin
// LoginActivity 중 옵저버부분
// 옵저버, 로그인 결과를 계속 지켜본다.
myLoginViewModel.resultLiveData.observe(this){
    if(it == true){
        // 로그인 성공했을 경우
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}   
```

<p> LoginViewModel - API 서버와 연결해서 로그인 성공 여부를 LiveData에 기록 </p>

```kotlin
val call = RetrofitBuilder.CONNET_SERVICE
call.login(id, pw).enqueue(object: Callback<loginResult>{
    // 연결 실패
    override fun onFailure(call: Call<loginResult>, t: Throwable) {
        _resultLiveData.value = false
    }
    override fun onResponse(call: Call<loginResult>, response: Response<loginResult>) {
        var result = response.body()?.result
        // 연결성공했을 경우 result 값을 성공으로 바꿔줌
        _resultLiveData.value = result == "true"
    }
})
```

<p> retrofit2을 이용해 API 서버와 연결</p>
<p> 싱글톤 패턴 사용 </p>

```kotlin
private val retrofitClient: Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl("http://ipaddress:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    // API서버와 연결 시 Retrofit객체를 구현할 인터페이스를 통해 만든다.
    val CONNET_SERVICE: APIInterface by lazy{
        retrofitClient.build().create(APIInterface::class.java)
    }
}
```

## 회원가입

### 코드
<p> 로그인과 같은 방식을 이용해 LoginActivity는 livedata를 옵저버, LoginViewmodel가 retrofit2을 통해 api 서버 연결, 로그인을 성공햇을 경우 livedata값을 바꿈</p>

## 메인화면

### 코드
<p> 막대 그래프는 로티 애니메이션을 사용했다. </p>

```kotlin
fun LottieAnimationView1(){
    //서버에서 가져온 음식 이름, 음식이름 실제로 가져왓을 때는 앞의 "음식이름"을 지우고 사용
    binding.foodName1.setText(firstFoodName)
    binding.foodLeft1.setText("${firstFood}일 남음")
    //Lottie 라인을 전체 100중 firstFood * 10인 50만큼만 채운다
    binding.animationView1.setMaxFrame(firstFood*10)
    //LottieAnimation 실행
    binding.animationView1.playAnimation()
}
```
## 음식추가 다이얼로그
### 코드
<p>  </p>

```kotlin
val builder = AlertDialog.Builder(this)
val dialogView = layoutInflater.inflate(R.layout.dialog_addfood, null)
builder.setView(dialogView)
    //확인버튼 클릭 시, 이름와 유통기한을 AllShelfLife로 보냄
    .setPositiveButton("확인") { dialogInterface, i ->
        Log.d(MainActivity.TAG, "HomeFragment - Positive Call()")
        //다이어로글에서 음식이름과 유통기한 editText를 가져온다.
        var Editname = dialogView.findViewById<EditText>(R.id.dialog_foodName)
        var EditshelfLife = dialogView.findViewById<EditText>(R.id.dialog_foodshelflife)
        var name = Editname.text.toString()
        var shelfLife = EditshelfLife.text.toString()
        //AllShelfLife로 dialog의 음식이름과 유통기한을 보낸다
        val intent = Intent(this, AllShelfLife::class.java)
        intent.putExtra("name", name)
        intent.putExtra("shelfLife", shelfLife)
        startActivity(intent)
    }
    //취소 버튼
    .setNegativeButton("취소") { dialogInterface, i ->
        /* 취소일 때 아무 액션이 없으므로 빈칸 */
        Log.d(MainActivity.TAG, "HomeFragment - Negative Call()")
    }
    .show()
```


## API Server 
 Spring boot 사용


## 프로젝트에 참가한 사람
- [@tmddmddnjs](https://github.com/tmddmddnjs)
