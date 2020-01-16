window.onload=function () {
    var lunboimg = document.getElementById('lunbo').getElementsByTagName('div');
    var n=0;
    function lunbofun() {
        for (var i=0;i<lunboimg.length;i++){
            lunboimg[i].style.display='none';
        }
        lunboimg[n].style.display='block';
    }
    function start(){
        n++;
        if (n>=lunboimg.length) {
            n=0;
        }
        lunbofun();
    }
    setInterval(start,3000);
}