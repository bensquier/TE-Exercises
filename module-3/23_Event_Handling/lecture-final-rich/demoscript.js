document.addEventListener('DOMContentLoaded', attachListeners);

function attachListeners (){
    let testButton = document.getElementById("btnTest");
    testButton.addEventListener('click', changeColor);
    
    document.getElementById("btnReset").addEventListener('click', resetColor);

    document.getElementById('btnBubble').addEventListener('click', bubbles);

    document.getElementById('parent').addEventListener('click', annoyed);

    document.getElementById('grandparent').addEventListener('click', annoyed);

    document.getElementById('greatgrandparent').addEventListener('click', annoyed);


}

function bubbles(ev){
    window.alert('Bubbles!!!!');
    ev.stopPropagation();
    window.alert(ev.currentTarget.id);
}

function annoyed(){
    window.alert('What do you want??');
}

function changeColor(){

    document.body.style.backgroundColor = "cornflowerblue";
}

function resetColor(){

    document.body.style.backgroundColor = "";
}