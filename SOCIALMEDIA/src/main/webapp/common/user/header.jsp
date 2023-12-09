<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light row">
		<div class="col-3 row nav-left">
			<svg class="logo" xmlns="http://www.w3.org/2000/svg"
				viewBox="0 0 20 20">
            <g>
              <circle fill="#FF4500" cx="10" cy="10" r="10"></circle>
              <path fill="#FFF"
					d="M16.67,10A1.46,1.46,0,0,0,14.2,9a7.12,7.12,0,0,0-3.85-1.23L11,4.65,13.14,5.1a1,1,0,1,0,.13-0.61L10.82,4a0.31,0.31,0,0,0-.37.24L9.71,7.71a7.14,7.14,0,0,0-3.9,1.23A1.46,1.46,0,1,0,4.2,11.33a2.87,2.87,0,0,0,0,.44c0,2.24,2.61,4.06,5.83,4.06s5.83-1.82,5.83-4.06a2.87,2.87,0,0,0,0-.44A1.46,1.46,0,0,0,16.67,10Zm-10,1a1,1,0,1,1,1,1A1,1,0,0,1,6.67,11Zm5.81,2.75a3.84,3.84,0,0,1-2.47.77,3.84,3.84,0,0,1-2.47-.77,0.27,0.27,0,0,1,.38-0.38A3.27,3.27,0,0,0,10,14a3.28,3.28,0,0,0,2.09-.61A0.27,0.27,0,1,1,12.48,13.79Zm-0.18-1.71a1,1,0,1,1,1-1A1,1,0,0,1,12.29,12.08Z"></path>
            </g>
          </svg>
			<input class="col-2 nav__search" type="search" placeholder="Search"
				aria-label="Search" />
			<div class="search-modal">
				<p class="search-modal__title">Recent</p>
				<ul class="list-group search-modal__result">
					<li class="list-group-item search-modal__item row"><img
						class="user-avatar col-2" alt="Subreddit Icon" role="presentation"
						src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
						class="_34CfAAowTqdbNDYXz5tBTW _1WX5Y5qFVBTdr6hCPpARDB"
						style="background-color: rgb(55, 60, 63)" />
						<p class="user-name col-6">Mỹ Phụng</p>
						<button class="close-btn col-2">
							<i class="fa-solid fa-xmark"></i>
						</button></li>
					<li class="list-group-item search-modal__item"><img
						class="user-avatar" alt="Subreddit Icon" role="presentation"
						src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
						class="_34CfAAowTqdbNDYXz5tBTW _1WX5Y5qFVBTdr6hCPpARDB"
						style="background-color: rgb(55, 60, 63)" />
						<p class="user-name">Mỹ Phụng</p></li>
					<li class="list-group-item search-modal__item"><img
						class="user-avatar" alt="Subreddit Icon"
						role-presentation"
                src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
						class="_34CfAAowTqdbNDYXz5tBTW _1WX5Y5qFVBTdr6hCPpARDB "
						style="background-color: rgb(55, 60, 63);">
						<p class="user-name">Mỹ Phụng</p></li>
					<li class="list-group-item search-modal__item"><img
						class="user-avatar" alt="Subreddit Icon" role="presentation"
						src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
						class="_34CfAAowTqdbNDYXz5tBTW _1WX5Y5qFVBTdr6hCPpARDB"
						style="background-color: rgb(55, 60, 63)" />
						<p class="user-name">Mỹ Phụng</p></li>
				</ul>
			</div>
		</div>
		<div class="col-6 nav-center">
			<ul class="nav nav-underline justify-content-center">
				<li class="nav-item col"><a class="nav-link active text-center"
					aria-current="page" href="#" onclick="handleActive()"> <i
						class="fa-solid fa-house icon"></i>
				</a></li>
				<li class="nav-item col"><a class="nav-link text-center"
					href="/SOCIALMEDIA/follower?id=" onclick="handleActive()"> <i
						class="fa-solid fa-user-group icon"></i>
				</a></li>
				<li class="nav-item col"><a class="nav-link text-center"
					href="#" onclick="handleActive()"> <i
						class="fa-solid fa-users me-2 icon"></i>
				</a></li>
				<li class="nav-item col"><a class="nav-link text-center"
					href="/SOCIALMEDIA/hiring" onclick="handleActive()"> <i
						class="fa-solid fa-briefcase icon"></i>
				</a></li>
			</ul>
			<div class="indicator"></div>
		</div>
		<div class="col-3 row nav-right">
			<div class="col-3 circle-icon">
				<i class="fa-solid fa-comment icon"></i>
			</div>
			<div class="col-3 circle-icon" onclick="handleNotifyModal()">
				<i class="fa-solid fa-bell icon"></i>
			</div>
			<div class="col-3 circle-icon">
				<i class="fa-solid fa-caret-down icon"></i>
			</div>
		</div>
	</nav>
</header>

<div class="notify-modal">
	<h2>
		Notifications - <span>2</span>
	</h2>
	<div class="notify-item">
		<img src="https://img.icons8.com/flat_round/64/000000/vote-badge.png"
			alt="img" />
		<div class="text">
			<h4>Samso aliao</h4>
			<p>Samso Nagaro Like your home work</p>
		</div>
	</div>
	<div class="notify-item">
		<img src="https://img.icons8.com/flat_round/64/000000/vote-badge.png"
			alt="img" />
		<div class="text">
			<h4>John Silvester</h4>
			<p>+20 vista badge earned</p>
		</div>
	</div>
</div>

<script>
function handleNotifyModal() {
    let notify = document.querySelector(".notify-modal");
    if (notify.style.display === "none") {
        notify.style.display = "block";
    } else {
        notify.style.display = "none";
    }
}
</script>