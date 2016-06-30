function validatePass(){
    var repeatParent = $('#register-form\\:pass2').parent();
    var password = $('#register-form\\:pass').val();
    var repeat = $('#register-form\\:pass2').val();
    
    if(password !== repeat || password.length === 0){
        //disable btn
        $('#register-form\\:register-button').prop('disabled', true);
        //Mark repeatfield
        if(repeatParent.hasClass("has-success"))
            repeatParent.toggleClass("has-success");
            
        if(!repeatParent.hasClass("has-error"))
            repeatParent.toggleClass("has-error");
        
    }else{
        //enable btn 
        $('#register-form\\:register-button').prop('disabled', false);
        //Mark repeatfield
        if(repeatParent.hasClass("has-error"))
            repeatParent.toggleClass("has-error");
        
        if(!repeatParent.hasClass("has-success"))
            repeatParent.toggleClass("has-success");
    }
}

$(document).ready(function(){
    validatePass();
});