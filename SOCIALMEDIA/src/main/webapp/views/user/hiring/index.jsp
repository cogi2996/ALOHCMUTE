<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./assets/font/themify-icons/themify-icons.css">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

    <style>
        .card-hire {
            display: flex;
            margin: 10px;
            padding: 10px;
            max-width: 550px;
        }

        .card-hire:hover {
            cursor: pointer;
        }

        .js-hidden-card {
            display: none;
        }

        .g-0 {
            display: flex;
            align-items: center;
        }

        .card-title {
            color: #0a66c2;
            padding: 0 0 5px;
        }

        .card-text {
            font-size: 16px;
            text-align: left;
            margin: 5px 0;
        }

        .img-logo {
            position: relative;
            width: 100px;
        }

        .icons {
            display: flex;
            position: absolute;
            top: 10px;
            right: 10px;
            flex-direction: column;
            align-items: flex-end;
        }

        .send {
            font-size: 24px;
            color: #353434;
            padding: 10px;
            border-radius: 50%;
        }

        .close {
            font-size: 28px;
            color: #353434;
            padding: 8px;
            border-radius: 50%;
        }

        .icon:hover {
            background-color: #cccccc;
        }
    </style>
</head>

<body>
    <div class="card card-hire ">
        <div class="row g-0">
            <div class="col-md-2">
                <img
                    src="https://career.fpt-software.com/wp-content/uploads/wp-jobhunt-users/FPT-Software_new-01-3-180x135.png"
                    class="img-logo" alt="">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title"> Data Analyst </h5>
                    <p class="card-text" id="business-name">FPT Ho Chi Minh City 1</p>
                    <p class="card-text" id="address"> Đường D1, Đ. D1, Phường Tân Phú, Quận 9, TP HCM</p>
                    <p class="card-text" id="money">Salary: 2000$ - 4000$ </p>
                    <p class="card-text" id="time-update"><small class="text-body-secondary">Last updated 3 mins
                            ago</small></p>
                </div>
            </div>
            <div class="col-md-2 icons">
                <ion-icon class="send icon" name="navigate-outline"></ion-icon>
                <ion-icon class="close icon" name="close-outline"></ion-icon>
            </div>
        </div>
    </div>

    <div class="card card-hire ">
        <div class="row g-0">
            <div class="col-md-2">
                <img
                    src="https://career.fpt-software.com/wp-content/uploads/wp-jobhunt-users/FPT-Software_new-01-3-180x135.png"
                    class="img-logo" alt="">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title"> Data Analyst </h5>
                    <p class="card-text" id="business-name">FPT Ho Chi Minh City 2</p>
                    <p class="card-text" id="address"> Đường D1, Đ. D1, Phường Tân Phú, Quận 9, TP HCM</p>
                    <p class="card-text" id="money">Salary: 2000$ - 4000$ </p>
                    <p class="card-text" id="time-update"><small class="text-body-secondary">Last updated 3 mins
                            ago</small></p>
                </div>
            </div>
            <div class="col-md-2 icons">
                <ion-icon class="send icon" name="navigate-outline"></ion-icon>
                <ion-icon class="close icon" name="close-outline"></ion-icon>
            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Thêm sự kiện click cho tất cả các icon close
                document.querySelectorAll('.close').forEach(function (icon) {
                    icon.addEventListener('click', function () {
                        // Tìm card chứa icon close và toggle class js-hidden-card
                        icon.closest('.card').classList.toggle('js-hidden-card');
                    });
                });
            });
            document.querySelectorAll('.send').forEach(function (locationIcon) {
                locationIcon.addEventListener('click', function () {
                    // Chuyển màu và làm mờ nút
                    locationIcon.style.color = '#cccccc';
                    locationIcon.style.pointerEvents = 'none';
                })
            });
        </script>
    </body>
</html>