    
$(document).ready(function(){
    $('#error-out').hide();

    var error = $.trim($('#login-error').text());
    
    if($('#login-error').children().length > 0){
    
        $('#login-error').hide();   
        
        if(error.toLowerCase().indexOf("bitte einloggen") >= 0){
            $('#error-out').text("Bitte Einlogen");
        }else{
            $('#error-out').text("Nutzername und/oder Passwort falsch");
        }
        
        $('#error-out').show();
        
    }else{
        $('#error-out').hide();
    }
    
});    
    