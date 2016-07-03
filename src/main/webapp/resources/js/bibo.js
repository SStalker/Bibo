/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    initListener();    
    
});

function initListener(){
    
    if( $('#searchButton').length) {
        $('#searchButton').click(search);        
    }
    
    if( $('#searchText').length) {
        $('#searchText').keyup(function(event){
            if(event.keyCode === 13)
                search(event);
        });        
    }
}

function search(event){
    event.preventDefault();
    event.stopImmediatePropagation();
    
    var searchText = $('#searchText').val();
    
    $("[id='hiddenForm:hiddenSearchText']").val(searchText);
    
    $("[id='hiddenForm:hiddenSearchButton']").click();
    
    return false;
}
