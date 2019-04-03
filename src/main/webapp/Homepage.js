class User {

   /**
    *
    * This is a helper class to establish a user as an object
    *
    * @param {string?/int?} userId
    * @param {strirng?/int?} empLevel
    * @param {string} firstname
    * @param {string} lastname
    * @param {string} fullMailingAdress
    * @param {String} email
    * @param {String} imgurl
    * @param {number} supId
    */
    constructor(userId, empLevel, firstname, lastname, fullMailingAdress, email,imgurl,supId) {
        this.userId = userId;
        this.empLevel = empLevel;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullMailingAdress = fullMailingAdress;
        this.email = email;
        this.imgurl = imgurl;
        this.supId = supId;

    }
}



var user = new User();

function getUser(){
    //AJAX - Asynchronous JavaScript and XML

    //Step 1. Create XHR
    let xhr = new XMLHttpRequest();

    //Step 2. Define event handler of on ready state change
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200){

            user = JSON.parse(xhr.responseText);


        }

    }

    xhr.open("GET", "localhost:8080/", true);
    xhr.send();

}


  function getAdressArray(u){
    return u.fullMailingAdress.split(";");
  }

  //// WARNING: LOOKOUT FOR THIS METHOD, likely can be optimized first place
  //to look if slow on load
  getUser();

  //image source
  document.getElementById("empimg").src = user.imgurl;

  //emp name
  var addressArray = getAdressArray(user);
  document.getElementById("empid").innerhtlm("<b>Employee ID:</b> "+user.empid);

  //emp adress info
  document.getElementById("empaddress").innerhtlm("<b>Address:</b> "+addressArray[0]);
  document.getElementById("empcitystate").innerhtlm(addressArray[1]);
  document.getElementById("empzip").innerhtlm(addressArray[2]);
