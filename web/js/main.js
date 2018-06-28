/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function(){
 console.log("Hello world!")
 
 var registroCompleto = $("#registroCompleto").text();
 console.log(registroCompleto)
 if(registroCompleto=="registro"){
     $("#alertRegistro").show();
     $("#alertFail").hide();
     $("#alertLogin").hide();
    
 } else if(registroCompleto=="login"){
     $("#alertRegistro").hide();
     $("#alertFail").show();
     $("#alertLogin").hide();
 }else {
     $(".alert").alert('close')
 }
});


