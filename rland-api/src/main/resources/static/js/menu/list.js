/**
 * 
console.log("test");
 let searchHeader = document.querySelector(".search-header");
 console.log(searchHeader);
 */
 
 
 window.addEventListener("load",function(){ // load= html이 다 끝나면 실행//defer와 차이?
	const ul = document.querySelector(".menu-category ul");
	const menubox = document.querySelector(".menu-list");
	let currentLi = document.querySelector(".menu-category ul li.menu-selected"); // 페이지가 로드되었을 때, 처음에 '전체'에 불이 들어온 것.
	
	// 	
	let controller = new AbortController();			 //AbortSignal 인터페이스는 DOM 요청(Fetch와 같은)과 통신하고 필요한 경우 AbortController 객체를 통해 취소할 수 있게 해주는 신호 객체를 나타냅니다.
													// 클릭할 때 마다 abort가 생성된다. 그래서 취소하고자 하는 것이 아니게 된다.
													// 새로운 것을 만들어야 하니까 const-> let으로 바꿈??. 새로 만들어 지는 것이 아니라 하나여야 한다.
	
	
	
	ul.onclick = function(e){
		//console.log("onclick");
		e.preventDefault(); 
		
		//console.log(currentTarget); // 현재 이벤트가 설정된 태그가 무엇이냐?
		//console.log(e.target.tagName);
		
		
		const el = e.target;
		if(menubox.classList.contains("ajax-loader")){
			if((confirm("기달 \n\r 요청을 취소하려면 확인 버튼을 눌러주세요"))){
				controller.abort();
				controller = new AbortController();
			}
			return;
		}
			
		
		if(el.tagName != "LI" && el.tagName != "A")
			return;
		
		let li = el;
		if(el.tagName == "A")
			li = el.parentElement; // 타겟의 부모. a태그의 부모=li
		//console.log(el.parentElement);
		//class 컬렉션	
		li.classList.add("menu-selected"); //클래스를 적용하겠다.		 // el.classList.add("menu-selected"); a태그만 색깔이 바뀐다.
		currentLi.classList.remove("menu-selected"); // 불이 들어온 것.
		
		currentLi = li;	//현재 클릭된 객체=currentLi 
		
		// 데이터를 요청 ?c=2 -> param:2
		// /api/menu/list?c=2
		// /api/menu/c/2  
		// /api/menu/list/cate/2 : 연관관계가 있어야 한다.
		// /api/menu/cate/2 
		
		// api/menus : 목록
		// api/menus/1 : 항목
		
		// 콜백개념의
		//XmalHttpRequest //파일 진척상황을 알려주는 기능을 가지고 있음
		//Fetch api //promise기능 제공
		// ` : 문자열과 변수($표시) 한번에 묶으려고
		let queryString = `?c=${currentLi.dataset.id}`; //fetch에 써줄 내용.
		if(currentLi.dataset.id == 0)
			queryString = "";
			
		// 요청전 -> 아이콘 띄우고
		menubox.classList.add("ajax-loader"); 
		
		
		const signal = controller.signal;
		let time=1;
		fetch( // MenuApi.java와 연결해줌 // fetch로는 바로 데이터를 사용할 수 없다. 그래서 url요청하고 응답에 json을 해줘야 한다. 
			`/api/menus${queryString}`,{signal}) //확인 누르면 취소되게 하려고(signal 옵션) // abortController를 사용해서 signal을 받음
		.then((response)=>response.json())	// js는 모든 것이 객체이다. 자바에서 보내는 list를 js는 바로 받지 못해서 JSON으로 변환한다.key, value로 사용가능.
		.then((list)=>{						// 
			menubox.innerHTML = ""; //menubox가 아이콘이 쓰일 장소(load) // 방을 비움. grabege로 만들어 버림.
									// 반복문을 통해 새로운 temp을 넣음. 문자열을 하나 넣고 만들어진 객체(insert). hidden이 들어간 객체 생성 후, hidden을 글자를 없애기 위해 다시 꺼내와야 한다. 
									// 지금 추가된 것을 꺼내야 한다. before로 인해 마지막이 된다. 
			// response.json()을 return해서 list(변수)에 넣는다.
			
		for(let m of list){	
			let template = `
			<section class="menu hidden">
                <form class="" action="list" method="post">
                    <h1>${m.name}</h1> 
                    <div class="menu-img-box"> 
                        <a href="detail.html"><img class="menu-img" src="/image/product/12.png"></a>
                    </div>    
                    <div class="menu-price">${m.price} 원</div>
                    <div class="menu-option-list">
                        <span class="menu-option">
                            <input class="menu-option-input" type="checkbox" name="ice" value="true">
                            <label>ICED</label>
                        </span>            
                        <span class="menu-option ml-2">
                            <input class="menu-option-input" type="checkbox" name="large" value="true">
                            <label>Large</label>
                        </span>
                    </div>
                    <div class="menu-button-list">
                   		<input type="hidden" name="menu-id">
                        <input class="btn btn-cancel btn-cancel-lg btn-size-1 btn-size-1-lg" type="submit" name="cmd" value="담기">
                        <input class="btn btn-default btn-default-lg btn-size-1 btn-size-1-lg ml-1" type="submit" name="cmd" value="주문하기">
                    </div>
                </form>
            </section> 
            `;
            // 문자열을 누적하는 능력이 없다. += 쓰면 안된다.
            // 누적하지 않고 사용하는 방법이 있다.
            // appendChild()- 고전적인 기능 / append()- 엘리먼트 여러 개 추가(코드?) 가능/ insertAdjacentElement() - 내가 원하는 위치에 element(태그)를 넣을 수 있다. / insertAdjacentHTML() - html를 원하는 위치에 넣을 수 있다.
            // menubox.insertAdjacentHTML("beforeend",template); // 메뉴박스가 끝나기 전에? beforeend: 닫는 태그 바로 위에 template을 넣겠다.
          													// box에서 집어 넣은 것(문자열template)을 빼야 할까? 막내 찾기
          													// 막내를 빼는 이유? hidden이 된 것을 빼야되기 때문
          													// 문자열을 가지고 객체를 만든다.
          													
          	// string 형태(문자열)의 html코드를 dom형태로 만들어 준다. 객체가 되서 반환이 된다. 											
          	let el = new DOMParser().parseFromString(template, "text/html") // dom형식으로 html으로 만들면 <html>안에 <body>안에 우리가 원하는 부분(template)시작이 <section>이다.
          							.body									// body태그 = > body안에 있는 
          							.firstElementChild;						// firstElementChild(첫번째 자식)을 객체로 만들어 달라 => section을 객체로 만들어 준다. 
          	menubox.append(el); // el 객체를 넣어준다. el에 dom이 들어있는데 한꺼번에 넣어준다.? 엘리먼트를 한번에 넣어준다./ insert는 6개가 한꺼번에 / el은 하나씩 꺼낼 수 잇다.								
              					// 객체를 하나씩 넣을 수 있게 하면서 setTimeout을 통해서 하나씩 시간차를 두면서 hidden을 사라지게 하면서 뜨게 할 수 있다. 
              			
              			
              			
             setTimeout(()=>{
				 el.classList.remove("hidden")
			 },1000*time)	
			time++; 								
          }													
          // 
          // setTimeOut 필요하다. 앞의 적용이 끝나고 내 것이 적용될 수 있도록
//          setTimeout(() =>{ 
//			 let length = menubox.children.length
//	         for(let i=0; i< length; i++)
//	          	menubox.children[i].classList.remove("hidden");
//          	},10*i);
          	
          
          
           // 아이콘 띄우기 취소
            menubox.classList.remove("ajax-loader"); 
		})
	/*	.catch(err=>{ // then에서 abort를 실패하면 보여주는 에러 메시지
			console.log(`fetch error:${err.message}`);
			menubox.classList.remove("ajax-loader"); 
		}) */
	}; 
 }); 
 
 
 
 
 
 
 