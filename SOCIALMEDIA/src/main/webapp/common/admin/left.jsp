<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Vertical Navbar -->
<nav
	class="navbar show navbar-vertical h-lg-screen navbar-expand-lg px-0 py-3 navbar-light bg-white border-bottom border-bottom-lg-0 border-end-lg"
	id="navbarVertical">
	<div class="container-fluid">
		<!-- Toggler -->
		<button class="navbar-toggler ms-n2" type="button"
			data-bs-toggle="collapse" data-bs-target="#sidebarCollapse"
			aria-controls="sidebarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Brand -->
		<a class="navbar-brand py-lg-2 mb-lg-5 px-lg-6 me-0" href="#">
			<h3 class="text-success">
				<img
					src="https://cdn.haitrieu.com/wp-content/uploads/2021/09/Logo-DH-Su-Pham-Ky-Thuat-TP-Ho-Chi-Minh-HCMUTE.png"
					width="40"><span class="text-info">ALO</span>HCMUTE
			</h3>
		</a>
		<!-- User menu (mobile) -->
		<div class="navbar-user d-lg-none">
			<!-- Dropdown -->
			<div class="dropdown">
				<!-- Toggle -->
				<a href="#" id="sidebarAvatar" role="button"
					data-bs-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<div class="avatar-parent-child">
						<img alt="Image Placeholder"
							src="https://images.unsplash.com/photo-1548142813-c348350df52b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
							class="avatar avatar- rounded-circle"> <span
							class="avatar-child avatar-badge bg-success"></span>
					</div>
				</a>
				<!-- Menu -->
				<div class="dropdown-menu dropdown-menu-end"
					aria-labelledby="sidebarAvatar">
					<a href="#" class="dropdown-item">Profile</a> <a href="#"
						class="dropdown-item">Settings</a> <a href="#"
						class="dropdown-item">Billing</a>
					<hr class="dropdown-divider">
					<a href="#" class="dropdown-item">Logout</a>
				</div>
			</div>
		</div>
		<!-- Collapse -->
		<div class="collapse navbar-collapse" id="sidebarCollapse">
			<!-- Navigation -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"> <i
						class="bi bi-house"></i> HOME
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#"> <i
						class="bi bi-people"></i> USERS
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#"> <i
						class="bi bi-globe-americas"></i> GROUPS
				</a></li>
			</ul>
			<!-- Divider -->
			<hr class="navbar-divider my-5 opacity-20">
			<!-- Navigation -->

			<!-- Push content down -->
			<div class="mt-auto"></div>
			<!-- User (md) -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"> <i
						class="bi bi-person-square"></i> Account
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="return confirm('Are you sure you want to logout?')"> <i
						class="bi bi-box-arrow-left"></i> Logout
				</a></li>
			</ul>
		</div>
	</div>
</nav>