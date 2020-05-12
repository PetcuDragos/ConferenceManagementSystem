<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12-May-20
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ubbproject.domain.MyUser" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-2.0.3.js"></script>
    <title>CMS</title>
    <script>
        var userId;
        $(document).ready(function () {
            $("#loginButton").click(function () {
                $.login("login.html",
                    function (id) {
                        userId = +id;
                    })
            })
        })
    </script>
</head>
<body>

<header>
    <div class="backtop">
        <div class="top">

            <div class="brand">
                <a href="index.html">Logo</a>
            </div>

            <div class="searchbox">
                <input type="search">
                <button type="submit" id="buton_cautare">
                    <svg width="24" style="stroke:#fff;stroke-width:0;vertical-align:bottom" height="24"
                         viewBox="0 0 24 24" data-icon="search">
                        <path d="M9 3C5.686 3 3 5.686 3 9c0 3.313 2.686 6 6 6s6-2.687 6-6c0-3.314-2.686-6-6-6m13.713 19.713c-.387.388-1.016.388-1.404 0l-7.404-7.404C12.55 16.364 10.85 17 9 17c-4.418 0-8-3.582-8-8 0-4.42 3.582-8 8-8s8 3.58 8 8c0 1.85-.634 3.55-1.69 4.905l7.403 7.404c.39.386.39 1.015 0 1.403">
                        </path>
                    </svg>
                </button>
            </div>

            <div class="top_bar_options">
                <ul id="list__top_bar_options">
                    <li class="conferences">
                        <span>&ensp;Conferences </span>
                    </li>

                    <li class="published">
                        <span> Published Papers </span>
                    </li>

                    <li class="members">
                        <span> Members </span>
                    </li>
                </ul>
            </div>


            <div class="top_bar_buttons">

                <div class="register">
                    <span> Sign up </span>
                </div>

                <div class="login" id="loginButton">
                    <span> Log in </span>
                </div>


            </div>

        </div>
    </div>

</header>

<div class="middle">
    <div class="left">

        <div class="user_info">
            <div id="user_title">
                <span>Pascotescu Iuliana Maria</span>
            </div>

            <ul class="user_list">
                <li>
                    Profile
                </li>

                <li>
                    <div class="logout">
                        <span> Log Out </span>
                    </div>
                </li>

                <li>
                    Notifications
                </li>

                <li>
                    <select id="group_list">
                        <optgroup label="Chair" disabled> <option value="Conference 1">Managements Conference</option>
                        </optgroup>
                        <optgroup label="PC-Member" disabled><option value="Conference 2">New Conference</option>
                        </optgroup>
                        <optgroup label="Member" disabled><option value="Conference 3">Car Conference</option>
                        </optgroup>
                    </select>
                </li>
            </ul>
        </div>

        <div class="subscribe_info">
            <div id="subscribe_title">
                <span>Subscribe to our Newsletter</span>
            </div>

            <div class="container">
                <form>
                    <input type="text" placeholder="Name" name="name" required>
                    <input type="text" placeholder="Email address" name="mail" required>
                    <label>
                        <input type="checkbox" checked="checked" name="subscribe" id="news"> Daily Newsletter
                    </label>
                    <input type="submit" value="Subscribe">
                </form>
            </div>
        </div>
    </div>


    <section class="main">

        <article class="panel">
            <div class="articol">
                <h3>Articol #1</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vitae dui at eros dictum finibus vel eget
                leo.
                Nam feugiat pharetra orci, eget ultricies erat imperdiet eu. Vivamus convallis, nunc eget imperdiet
                scelerisque, eros elit lobortis sapien, id mattis enim felis sit amet turpis.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>

        <article class="panel">
            <div class="articol">
                <h3>Articol #2</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Praesent semper sapien mi, quis mollis tellus rutrum id. Nullam fringilla elementum gravida. Duis diam
                massa, hendrerit in dapibus vitae, semper id est. Quisque tempus nibh vehicula, porttitor est et, tempus
                metus. Praesent sed euismod dolor. Integer suscipit luctus mi a condimentum. Praesent pulvinar, magna
                vel
                feugiat viverra, ex felis lobortis diam, in gravida nulla nisi sed purus. Ut vestibulum porttitor
                tristique.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>

        <article class="panel">
            <div class="articol">
                <h3>Articol #3</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Aenean aliquam turpis ac orci pharetra pharetra. Cras maximus nulla suscipit libero euismod aliquet.
                Duis
                pharetra hendrerit ex id faucibus. Donec vulputate justo id dolor mollis rutrum. Etiam iaculis velit
                vitae
                lobortis venenatis. Phasellus pharetra enim sit amet neque ultricies, vitae tristique lectus volutpat.
                Sed
                hendrerit ex quis magna venenatis porttitor.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>

        <article class="panel">
            <div class="articol">
                <h3>Articol #4</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vitae dui at eros dictum finibus vel eget
                leo.
                Nam feugiat pharetra orci, eget ultricies erat imperdiet eu. Vivamus convallis, nunc eget imperdiet
                scelerisque, eros elit lobortis sapien, id mattis enim felis sit amet turpis.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>

        <article class="panel">
            <div class="articol">
                <h3>Articol #5</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Praesent semper sapien mi, quis mollis tellus rutrum id. Nullam fringilla elementum gravida. Duis diam
                massa, hendrerit in dapibus vitae, semper id est. Quisque tempus nibh vehicula, porttitor est et, tempus
                metus. Praesent sed euismod dolor. Integer suscipit luctus mi a condimentum. Praesent pulvinar, magna
                vel
                feugiat viverra, ex felis lobortis diam, in gravida nulla nisi sed purus. Ut vestibulum porttitor
                tristique.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>

        <article class="panel">
            <div class="articol">
                <h3>Articol #6</h3>
                <span>Status:</span>
            </div>
            <hr/>
            <p>
                Aenean aliquam turpis ac orci pharetra pharetra. Cras maximus nulla suscipit libero euismod aliquet.
                Duis
                pharetra hendrerit ex id faucibus. Donec vulputate justo id dolor mollis rutrum. Etiam iaculis velit
                vitae
                lobortis venenatis. Phasellus pharetra enim sit amet neque ultricies, vitae tristique lectus volutpat.
                Sed
                hendrerit ex quis magna venenatis porttitor.
            </p>
            <hr/>
            <input type="submit" value="Review">
            <input type="submit" value="Evaluate">
        </article>
    </section>
</div>

</body>
</html>