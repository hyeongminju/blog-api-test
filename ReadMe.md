# 블로그 검색
### Kakao blog 검색 API 를 이용한 결과 리턴
### Kakao blog 검색 API 가 동작하지 않을 경우 Naver API 활용하여 결과 리턴
### Kakao blog 검색 시 parameter utf-8 url-encoding 할 것
## API 명세 
### URI : /search/blog 
### Parameter : 
```
{
    "query" : "String", notempty required=true 
    "page": Integer, 1-50
    "size": Integer, 1-50
    "sort": "String" accuracy|recency defaultValue = accuracy
}
```
### Response 
#### 카카오 블로그 검색의 경우 
```

{
    "meta": {
        "total_count": 5615,
        "pageable_count": 800,
        "is_end": false
    },
    "documents": [
        {
            "title": "[이영작박사 칼럼] 현 윤석열 정부를 뜨겁게 달구는 현안들에 대한 제언",
            "contents": "EC%9E%<b>A</b>5%20%EC%97%<b>B</b>0%EC%84%A4%E2%<b>80%</b><b>A6</b>%<b>EA</b>%<b>B</b>9%<b>80%</b><b>EB</b>%8C%<b>80%</b>EC%A4%91%EC%9D%<b>80%</b>20%EC%<b>A</b>3%BC%<b>EB</b>%AA%A9%<b>EB</b>%<b>B</b>0%9B%<b>EB</b>%8A%<b>94</b>%20%EC%9D%98%EC%9B%90%EC%9D%<b>B</b>4%20%<b>EB</b>...84%EC%84%<b>9C</b>%20%EF%BD%<b>9C</b>%20%EC%9D%<b>B</b>4%ED%9D%<b>AC</b>%ED%98%<b>B</b><b>8%</b>20%ED%8F%89%EC%<b>A</b>0%84%5D%20%EC%<b>A</b>0%9C2%<b>EB</b>%<b>B</b>6%<b>80%</b>20%<b>EB</b>%A7%8C%<b>EB</b>%82%<b>A</b><b>8%</b><b>EA</b>%<b>B</b>3%BC%20%<b>EB</b>%8F%99%ED...",
            "url": "https://blog.naver.com/johnjung56/223052330370",
            "blogname": "정연태의 만리풍취",
            "thumbnail": "https://search1.kakaocdn.net/argon/130x130_85_c/6ZQ5OTmin4d",
            "datetime": "2023-03-22T15:32:00.000+09:00"
        },
        {
            "title": "Done is better than perfect.",
            "contents": "95%98%<b>EA</b>%<b>B</b>3%<b>A</b>0%20%<b>EB</b>%8C%<b>80%</b><b>EB</b>%<b>B</b>6%<b>80%</b><b>EB</b>%<b>B</b>6%84%20%EC%98%A4%ED%95%<b>B</b>4%ED%95%98%<b>EB</b>%8A%<b>94</b>%3F %EC%8B%<b>A</b>0%ED%98%95%EC%<b>B</b>2%<b>A</b>0%EC%9D%98%20%<b>EA</b>%<b>B</b>2%A9%EC%<b>A</b>3%BC%EC%8B%<b>9C</b>%ED%99%<b>94</b>%20%28%E9%9A%<b>94</b>%E9%<b>80%</b><b>B</b><b>1%</b>E<b>8%</b>A9%A9%E<b>8%</b>A9%<b>B</b><b>1%</b>29-%E2%<b>80%</b>98%<b>EA</b>%<b>B</b>0%<b>80%</b>EC%A7%<b>80%</b>20%EC%95%8A%EC%9D%<b>80%</b>20%<b>EA</b>%<b>B</b><b>8%</b><b>B</b><b>8%</b>E2%<b>80%</b>99%20%EC%86%<b>8D</b>%EC%9D...",
            "url": "https://blog.naver.com/deg9810/223051740463",
            "blogname": "[일상을 보라] 보라 블로그",
            "thumbnail": "https://search3.kakaocdn.net/argon/130x130_85_c/EPHJ3CYF7BV",
            "datetime": "2023-03-21T23:29:00.000+09:00"
        }
    ]
}
```

#### 네이버의 경우 
```
{
    "lastBuildDate": "Wed, 22 Mar 2023 22:00:07 +0900",
    "total": 211702,
    "start": 1,
    "display": 2,
    "items": [
        {
            "title": "[1주차] CTF (Webhacking 문제풀이)",
            "link": "https://blog.naver.com/aosh8974/223052749789",
            "description": "<b>EB%</b><b>94%</b>A9%EC%9D%84-%EC%95%84%EC%8A%A4%ED%82%A4-<b>%EB%</b><b>AC</b>%<b>B8%</b>EC%9E%90<b>%EB%</b><b>A1%9C</b>-<b>%EB%</b>B3%<b>80%</b>ED%99%98 &amp; (참고) 즉 admin을... 각각 d, <b>a</b>, s, w, |(파이프)를 의미한다고 한다. 이 값들을 키보드로 눌러주면 문제가 해결된다.",
            "bloggername": "Information Security",
            "bloggerlink": "blog.naver.com/aosh8974",
            "postdate": "20230322"
        },
        {
            "title": "2023년 기대되는 AI 기술 트렌드 10가지",
            "link": "https://blog.naver.com/sealiger/223052738206",
            "description": "Best 5 스몰 비즈니스를 위한 로우코드 개발 플랫폼 Best 5 출처]디지털 인사인트 매거진 https://digit2sight.com/2023<b>%eb%</b>85%84-<b>%ea%b8%</b>b0<b>%eb%</b>8c%<b>80%eb%</b>90%98<b>%eb%</b>8a%<b>94</b>-ai-<b>%ea%b8%</b>b0%ec%88%a0-%ed%8a%<b>b8%</b><b>eb%</b>a0%8c<b>%eb%</b>93%<b>9c</b>-10<b>%ea%b</b>0%<b>80%</b>ec%a7%80/",
            "bloggername": "sealiger님의 블로그",
            "bloggerlink": "blog.naver.com/sealiger",
            "postdate": "20230322"
        }
    ]
}
```
# 인기 검색어 목록
### In-Memory h2 를 사용하여 블로그 검색 요청이 들어올때마다 DB 에 저장한다.
### 인기 검색어 목록을 요청할 때 요청수로 정렬하여 Top10 리스트를 리턴한다.

## API 명세 
### URI : /keyword
### Parameter : 
#### 없음

### Response 
```
[
    {
        "keyword": "더 글로리8",
        "hit": 10
    },
    {
        "keyword": "더 글로리10",
        "hit": 10
    },
    {
        "keyword": "더 글로리7",
        "hit": 9
    },
    {
        "keyword": "더 글로리9",
        "hit": 9
    },
    {
        "keyword": "더 글로리6",
        "hit": 6
    },
    {
        "keyword": "더 글로리5",
        "hit": 5
    },
    {
        "keyword": "더 글로리4",
        "hit": 4
    },
    {
        "keyword": "더 글로리3",
        "hit": 3
    },
    {
        "keyword": "더 글로리2",
        "hit": 2
    },
    {
        "keyword": "더 글로리1",
        "hit": 1
    }
]
```

## 사용한 오픈소스
 : org.springframework.boot:spring-boot-starter-web

 : org.springframework.boot:spring-boot-starter-webflux(비동기 api 호출)

 : org.springframework.boot:spring-boot-starter-jdbc(DB사용)

 : com.h2database:h2(In-memory사용)

 : spring-boot-starter-data-jpa(JPA 사용)

 : gson : 데이터 파싱용

 : lombok : gettter/setter 

 : spring-boot-starter-validation : parameter validation