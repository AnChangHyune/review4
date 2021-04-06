function isTouchDevice() {
	return (('ontouchstart' in window) || (navigator.maxTouchPoints > 0) || (navigator.msMaxTouchPoints > 0));
}

const $html = document.querySelector('html');
$html.classList.add(isTouchDevice() ? 'touch-posible' : 'touch-imposible');

function openNav() {
	document.getElementById("mySidenav").style.display = "block";
}

function closeNav() {
	document.getElementById("mySidenav").style.display = "none";
}

function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "0px";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
  document.body.style.backgroundColor = "white";
}