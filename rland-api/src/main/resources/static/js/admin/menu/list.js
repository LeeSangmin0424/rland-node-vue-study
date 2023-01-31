window.addEventListener("load",function(){
   const menuSection = document.querySelector(".menu-section");
   const btnAdd = document.querySelector(".btn-add");
   const menuRegSection = menuSection.querySelector(".menu-reg-section");
   const imgInput = document.querySelector(".img-input");
   const fileInput = document.querySelector(".file-input");
   let btnReg = document.querySelector(".btn-reg")
   
   // 삭제 기능
   menuSection.onclick = function(e){
      
      e.preventDefault();
      if(!e.target.classList.contains("btn-del"))
         return;
    
       console.log(e.target.dataset.id);
       //let section = null;
       let el = null;
       for(el=e.target;el.tagName!="SECTION";el=el.parentElement);
          console.log("el"+el);
       
       let id = el.dataset.id;
       
         fetch(`/api/menus/${id}`,{method:"DELETE"})
         .then(resp=>resp.json())
         .then(data=>{
           let result = data.resultObject;
           console.log("result"+result);
           if(result==1){
			  console.log("삭제완료");              
              //section 을 제거
              //+ 삭제전에 컨펌과정 필요 
              el.remove();
           }
              
              console.log("id"+id);
      });
      
         /*1226 section 안
       1) 백엔드에선 type="hidden" 의 값을
       2) 삭제 버튼의 값에 데이터를 꽂아주기 - list.html 에서 data-id=${menu.id}
    */
    
    }; // section
   
    btnReg.onclick = function(e){
		e.preventDefault();
		
      let img =fileInput.files[0];
      //element가 아닌 그 값을 받아야함
      let name = menuRegSection.querySelector("input[name='name']").value;
      let price = menuRegSection.querySelector("input[name='price']").value;
      
      
      //위 데이터들을 포장할 FormData(mdn 검색) , html 에선 <form> 
      let form = new FormData();
      
      //이름과 매칭해야함 , 매칭이안되면 @requestParam으로 별칭사용
      form.append("img",img);
      form.append("name",name);
      form.append("price",price);
      
      //포장한 데이터를 보낼
     
      //가지고갈데이터가 있으면 post , 비동기로 처리중 
      fetch("/api/menus/reg",{method:"post" , body:form})
      .then(data=> // data = MenuApi에서 넘어온 dti이다.
		  data.json() // data를 json으로 바꿈.
      )
      .then(json=>{
		  let menu = json.resultObject; // json.resultObject는 dto.put해준 menu이다. 그래야 ${meu.name}으로 사용가능.
		  let status = json.status;
		  //console.log(status);
		  //list.html 에서 첫번째 섹션(등록부분) 다음에 새로운 메뉴를 추가해야함 
	      let template = `
	      <section class="menu border-bottom border-color-1">
	                      <form class="">
	                          <h1 >${menu.name}</h1> 
	                          <div class="menu-img-box">
	                              <a href="${menu.id}"><img class="menu-img" src="/image/product/${menu.img}"></a>
	                          </div>    
	                          <div class="menu-price" >${menu.price}</div>
	                          <div class="menu-option-list">
	                              <span class="menu-option">
	                                  <input class="menu-option-input" type="checkbox">
	                                  <label>ICED</label>
	                              </span>
	                              <span class="menu-option ml-2">
	                                  <input class="menu-option-input" type="checkbox">
	                                  <label>Large</label>
	                              </span>
	                          </div>
	                     <div class="menu-button-list">
	                        
	                        <input class="btn btn-line btn-round btn-size-1 rounded-0-md" type="submit" value="수정">
	                              <input class="btn btn-fill btn-round rounded-0-md btn-size-1 ml-1 btn-del" type="submit" value="삭제">
	                          </div>
	                      </form>
	                  </section>
	      `;
	   //객체를만들어서 추가,그냥 추가
	      //reg 폼 뒤에 (afterend template) 추가
	      menuRegSection.insertAdjacentHTML("afterend",template)
	  });
      
      
   }; //btnReg
   
   
   
   btnAdd.onclick=function(e){
      e.preventDefault();
      menuRegSection.classList.remove("d-none");
      console.log("메뉴추가버튼");
   };
   
   imgInput.onclick=function(e){
      e.preventDefault();
      let event = new MouseEvent("click",{
         'view':window,
         'bubble':true,
         'cancelable':true
         
      });
      fileInput.dispatchEvent(event); //이거무슨의미 
   }
   
   //미리보기로 한 이미지를 
   fileInput.oninput = function(e){
      let url =fileInput.files[0];
      
      let reader = new FileReader();
      reader.onload = (evt)=>{
         imgInput.src = evt.target.result;
      };
      reader.readAsDataURL(url);
   }
   
});


