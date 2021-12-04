function radioButtonCheck() {
var radios = document.getElementsByName("pref");
var value;
var i;
for (i = 0; i < radios.length; i++) {
    if (radios[i].checked) {
        if (i==0)
          {
            var dropDown = document.getElementById("sel1");  
            dropDown.selectedIndex = 0;
            document.getElementById('sel1').setAttribute("disabled","disabled");
            document.getElementById('genre').removeAttribute("disabled");
          }
        else if(i==1){
          var dropDown = document.getElementById("genre");  
          dropDown.selectedIndex = 0;
          document.getElementById('genre').setAttribute("disabled","disabled");
         document.getElementById('sel1').removeAttribute("disabled");
          }
      else{
        document.getElementById('sel1').removeAttribute("disabled");
        document.getElementById('genre').removeAttribute("disabled");
      }
      
    }
  }
}


function checkDropDown(opt1)
{
  var e = document.getElementById(opt1);
  var strUser = e.options[e.selectedIndex].value;
  return strUser;
}
function getRandomInt(max) {
  return Math.floor(Math.random() * Math.floor(max));
}
 


function recommendBook() {
  var categories = ["Novel", "Fiction", "Narrative", "Mystery"];
  var language = ["English","French"];
 
  var Books= [
               {book_name: "The Great Gatsby", language:"English", category:"Novel" , image: "https://i.ibb.co/h9t5JbC/the-great-gatsby.jpg"},
               {book_name: "Candide", language:"French", category:"Novel" , image: "https://i.ibb.co/nQ1rfDq/candide.jpg"},

               {book_name: "Jurassic Park", language:"English", category:"Fiction" , image: "https://i.ibb.co/7j64bKk/jurassic-park.jpg"},                
               
    
               {book_name: "The Fault in our stars", language:"English", category:"Narrative" , image: "https://i.ibb.co/X50zzmy/the-fault-in-our-stars.jpg"},
               {book_name: "Madame Bovary", language:"French", category:"Narrative" , image: "https://i.ibb.co/58kw9M2/madame-bovary.jpg"},
    
               {book_name: "Murder on the Orient Express", language:"English", category:"Mystery" , image: "https://i.ibb.co/Qfc3MBZ/murder.jpg"},
               {book_name: "L'homme aux cercles bleus", language:"French", category:"Mystery", image: "https://i.ibb.co/sbmnbcB/homme.jpg"}
             
  ];
  
  
  var option;
  option = radioButtonCheck();
  var categoryOpt;
  var langOpt;
  
  categoryOpt = checkDropDown("genre");
  langOpt = checkDropDown("sel1");
  var candidateBooks = [];
  
  
  if (langOpt == "")
    {
      
      for (var i = 0; i<Books.length; i++)
        {
          // document.getElementById("test").value = "11";
          if (Books[i].category == categoryOpt)
            {
              candidateBooks.push(i);
            }
        }
      if (candidateBooks.length!=0)
        {
		var randomInt = getRandomInt(candidateBooks.length);
          document.getElementById("output").value = Books[candidateBooks[randomInt]].book_name;
	document.getElementById('bigpic').style.display='block';
	document.getElementById('bigpic').src= Books[candidateBooks[randomInt]].image;
        }
      else{
        document.getElementById("output").value = "No Books for this search option";
      }

    }
  
  else if (categoryOpt == "")
    {
      
      for (var i = 0; i<Books.length; i++)
        {
          //document.getElementById("test").value = "11";
          if (Books[i].language == langOpt)
            {
              candidateBooks.push(i);
            }
        }
      if (candidateBooks.length!=0)
        {
   	var randomInt = getRandomInt(candidateBooks.length);
          document.getElementById("output").value = Books[candidateBooks[randomInt]].book_name;
	document.getElementById('bigpic').style.display='block';
	document.getElementById('bigpic').src= Books[candidateBooks[randomInt]].image;
        }
      else{
        document.getElementById("output").value = "No Books for this search option";
      }

    }
  
  else
    {
      for (var i = 0; i<Books.length; i++)
        {
          // document.getElementById("test").value = "11";
          if (Books[i].category == categoryOpt && Books[i].language == langOpt)
            {
              candidateBooks.push(i);
            }
        }
      if (candidateBooks.length!=0)
        {
   	var randomInt = getRandomInt(candidateBooks.length);
          document.getElementById("output").value = Books[candidateBooks[randomInt]].book_name;
	document.getElementById('bigpic').style.display='block';
	document.getElementById('bigpic').src= Books[candidateBooks[randomInt]].image;
        }
      else{
        document.getElementById("output").value = "No Books for this search option";
      }
    }
}