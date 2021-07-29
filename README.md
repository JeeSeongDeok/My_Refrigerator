# My_Refrigerator
<p> K-Hackathon 공모전에 참가하기 위해서 개발한 냉장고 관리 어플리케이션이다. </p>
<p> 혼자살거나 일상이 바빠서 냉장고 관리를 제대로 하지 못하는 사람들을 위해 개발한 어플리케이션이다.</p>
<p> MVVM 아키텍처를 이용해서 유지보수가 쉽도록 만들었다.</p>

## 로그인 화면
### 디자인
<img src = "https://user-images.githubusercontent.com/23256819/127474829-1bfb391e-ad0c-4997-a0b2-1b19f43d1adf.png" width=50% height= 20%>

### 결과
<img src = "https://user-images.githubusercontent.com/23256819/127477410-82e8691b-7e85-4bfb-b4d0-6005c3b147a2.PNG">

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

### 디자인
<img src = "https://user-images.githubusercontent.com/23256819/127477223-2b53cb17-4d71-4f70-a6ed-0061a1192457.png" width=50% height= 30%>
<img src = "https://user-images.githubusercontent.com/23256819/127477233-4b5aa818-e000-4bfb-b8a5-f600886a65a8.png" width=50% height=30%>

### 결과
<img src = "https://user-images.githubusercontent.com/23256819/127477702-1c603930-9d9d-4363-bcd5-8df5eb95386f.PNG">

### 코드
<p> 로그인과 같은 방식을 이용해 LoginActivity는 livedata를 옵저버, LoginViewmodel가 retrofit2을 통해 api 서버 연결, 로그인을 성공햇을 경우 livedata값을 바꿈</p>

## 메인화면

### 디자인
<img src = "https://user-images.githubusercontent.com/23256819/127477772-3a18a271-0b8e-4dbb-a186-2ca10b8e721f.png" width = 50% height = 50%>

## 설정화면

### 디자인
<img src = "https://user-images.githubusercontent.com/23256819/127477779-1f669788-fab2-46ff-b3c7-58fc971a34ec.png" width =50% height =50%>
## API Server 
 Spring boot 사용


## 프로젝트에 참가한 사람
- [@tmddmddnjs](https://github.com/tmddmddnjs)
