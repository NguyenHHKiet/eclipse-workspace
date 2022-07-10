<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!-- 
author name: hoangkiet
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Templatess</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@0,200;0,300;0,400;0,600;0,700;0,900;1,200;1,300;1,400;1,600;1,700;1,900&display=swap"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<link rel="stylesheet" href="static/style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html {
	font-family: 'Source Sans Pro', sans-serif;
	position: relative;
	min-height: 100%;
}

body {
	margin-bottom: 60px;
}
h1 {
  font-size: inherit;
  font-weight: inherit;
}
p {
	font-family: 'Lato', sans-serif;
	font-weight: 300;
	text-align: center;
	font-size: 18px;
	color: #676767;
}
a {
  color: inherit;
  text-decoration: inherit;
}
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}

button {
	margin: 10px;
	text-transform: none;
}
.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-family: 'Lato', sans-serif;
	font-weight: 500;
	background: transparent;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

.btn-2 {
	background: rgb(96, 9, 240);
	background: linear-gradient(0deg, rgba(96, 9, 240, 1) 0%,
		rgba(129, 5, 240, 1) 100%);
	border: none;
}

.btn-2:before {
	height: 0%;
	width: 2px;
}

.btn-2:hover {
	box-shadow: 4px 4px 6px 0 rgba(255, 255, 255, .5), -4px -4px 6px 0
		rgba(116, 125, 136, .5), inset -4px -4px 6px 0 rgba(255, 255, 255, .2),
		inset 4px 4px 6px 0 rgba(0, 0, 0, .4);
}

table {
	text-indent: 0;
	border-color: inherit;
	border-collapse: collapse;
}

.w-full {
	width: 100%;
}

body>.container {
	padding: 60px 15px 0;
}

.container .text-muted {
	margin: 20px 0;
}

.footer>.container {
	padding-right: 15px;
	padding-left: 15px;
}

code {
	font-size: 80%;
}

*::-webkit-scrollbar {
	width: 0.35em;
	height: 0.35em;
	background-color: transparent;
	border-radius: 1rem;
}

*::-webkit-scrollbar-thumb {
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 1rem;
}

* {
	scrollbar-color: rgba(0, 0, 0, 0.5) transparent;
}

[hidden] {
	display: none;
}

.justify-center {
	justify-content: center;
}

.table {
	display: table;
}

.flex-col {
	flex-direction: column;
}

.hidden {
	display: none;
}

.rounded-lg {
	border-radius: 0.5rem;
}

.overflow-y-auto {
	overflow-y: auto;
}

.outline {
	outline-style: solid;
}

.outline-2 {
	outline-width: 2px;
}

.outline-gray-500 {
	outline-color: #6b7280;
}

.max-h-\[60vh\] {
	max-height: 60vh;
}

.flex {
	display: flex;
}

.mt-8 {
	margin-top: 2rem;
}

button, [role="button"] {
	cursor: pointer;
}

:disabled {
	cursor: default;
}

[type='search'] {
	-webkit-appearance: textfield;
	outline-offset: -2px;
}

button, [type='button'], [type='reset'], [type='submit'] {
	-webkit-appearance: button;
	background-image: none;
}

abbr[title] {
	-webkit-text-decoration: underline dotted;
	text-decoration: underline dotted;
}

.border-b-2 {
	border-bottom-width: 2px;
}

.border-dashed {
	border-style: dashed;
}

.border-gray-400\/40 {
	border-color: rgb(156 163 175/ 0.4);
}

.px-2 {
	padding-left: 0.5rem;
	padding-right: 0.5rem;
}

.px-1 {
	padding-left: 0.25rem;
	padding-right: 0.25rem;
}

.py-2 {
	padding-top: 0.5rem;
	padding-bottom: 0.5rem;
}

.px-1 {
	padding-left: 0.25rem;
	padding-right: 0.25rem;
}

.px-3 {
	padding-left: 0.75rem;
	padding-right: 0.75rem;
}.text-4xl {
  font-size: 2.25rem;
  line-height: 2.5rem;
}
.mt-3 {
  margin-top: 0.75rem;
}
.text-base {
	font-size: 1rem;
	line-height: 1.5rem;
}.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  
} .form-signin-heading,
.checkbox {
  margin-bottom: 30px;
}.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}	.form-control {
 position: relative;
 font-size: 16px;
 height: auto;
 padding: 10px;
}	
input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}

input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}.cancelbtn {
    width: auto;
    padding: 6px 12px;
    background-color: #f44336;
}
#myInput {
  background-image: url();
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
</style>
</head>
<body class="container">
<span class="btn"><a href="">Home</a></span>
<button class="btn" onclick="document.getElementById('id01').style.display='block'">Login</button>
<button class="btn" onclick="document.getElementById('id02').style.display='block'">Signup</button>
  <div id="id01" class="wrapper modal">
    <form class="form-signin modal-content animate">       
      <h2 class="form-signin-heading">Please Login</h2>
      <input type="text" class="form-control" name="username" placeholder="User Name" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">  
      <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'"
        class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div> 
    </form>
	<c:if test="${not empty errorMessage}">
	   <c:out value="${errorMessage}"/>
	</c:if>
	<c:if test="${not empty successMessage}">
	   <c:out value="${successMessage}"/>
	</c:if>
	<!-- 
	if(res.next())
        {
                if ((thisname.equals(res.getString("username"))) && (thispwd.equals(res.getString("password"))))
                {
                    session.setAttribute("username", request.getParameter("username"));
                    request.setAttribute("successMessage", "Successful Valid"); 
                }
                else{
                    session.invalidate();
                    request.setAttribute("errorMessage", "Invalid user or password");         
                }
	 -->

  </div>
  <div id="id02" class="wrapper modal">
    <form class="form-signin modal-content animate">       
      <h2 class="form-signin-heading">Please Signup</h2>
      <input type="text" class="form-control" name="username" placeholder="User Name" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="Signup">  
      <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'"
        class="btn btn-block btn-danger">Cancel</button>
      
    </div> 
    </form>
    
  </div>



	<h1 class="text-center text-4xl mt-3 mb-2 px-4 py-2">
		<a href="#"> Live Soccer </a>
	</h1>

	<div class="container">
		<p>Hello World to Team 01</p>
		<div class="page-header text-center">
		
			<h2 class="align-right">Search Line Name</h2>
				<input class="mt-3 my-3" type="text" id="myInput" onkeyup="myFunction()" 
				placeholder="Search for names.." title="Type in a name">

<!-- INSERT TEAM -->
  	<div id="insertteam" class="wrapper modal">
    <form class="form-signin modal-content animate" action="insertteam" method="post">       
      <h2 class="form-signin-heading">Insert Team</h2>
      
      
      <input type="text" class="form-control" name="team_name" placeholder="Team Name" required=""/>
      <input type="date" class="form-control" name="team_founded" placeholder="Founded" required="required"/>
      <input type="text" class="form-control" name="team_stadium" placeholder="Stadium" required="required"/>
      <input type="number" class="form-control" name="manager_id" placeholder="Manager Id" required="required"/>
      <input type="number" class="form-control" name="league_id" placeholder="League Id" required="required"/>
  
      <input class="btn btn-primary btn-block" type="submit" value="Insert">
      <c:if test="message">
     	<p>${message}</p>
     </c:if>
      <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('insertteam').style.display='none'" class="cancelbtn">Cancel</button>
  
    </div> 
    </form>
  </div>
<!-- INSERT PLAYER -->
 <div id="insertplayer" class="wrapper modal">
   <form class="form-signin modal-content animate" action="insertplayer" method="post">       
     <h2 class="form-signin-heading">Insert Player</h2>
     
     <input type="text" class="form-control" name="player_name" placeholder="Player Name" required=""/>
     <input type="date" class="form-control" name="player_birth" placeholder="Birth" required="required"/>
     <input type="number" class="form-control" name="position_id" placeholder="Position Id" required="required"/>
     <input type="number" class="form-control" name="team_id" placeholder="Team Id" required="required"/>
     <input type="number" class="form-control" name="nation_id" placeholder="Nation Id" required="required"/>
     
     <input class="btn btn-primary btn-block" type="submit" value="Insert">  
     <c:if test="message">
     	<p>${message}</p>
     </c:if>
     <div class="container" style="background-color:#f1f1f1">
     <button type="button" onclick="document.getElementById('insertplayer').style.display='none'" class="cancelbtn">Cancel</button>
 
   </div> 
   </form>
 </div>
<!-- INSERT MATCH -->
<div id="insertmatch" class="wrapper modal">
    <form class="form-signin modal-content animate" action="insertmatch" method="post">       
      <h2 class="form-signin-heading">Insert Match</h2>
      
      <input type="date" class="form-control" name="matches_date" placeholder="Matches Date" required=""/>
      
      <input type="number" class="form-control" name="home_team" placeholder="Team Id Home Team" required="required"/>
      <input type="number" class="form-control" name="away_team" placeholder="Team Id Away Team" required=""/>
      <input type="number" class="form-control" name="home_score" placeholder="Home Team Score" required=""/>
      <input type="number" class="form-control" name="away_score" placeholder="Away Team Score" required="required"/>
        
      <input class="btn btn-primary btn-block" type="submit" value="Insert">  
      <c:if test="message">
     	<p>${message}</p>
     </c:if>
      <div class="container" style="background-color:#f1f1f1">
     <button type="button" onclick="document.getElementById('insertmatch').style.display='none'" class="cancelbtn">Cancel</button>
 
   </div> 
   </form>
 </div>
<!-- INSERT HISTORY PROCCES NOT YET -->
  	<div id="inserthistory" class="wrapper modal">
    <form class="form-signin modal-content animate">       
      <h2 class="form-signin-heading">Insert History</h2>
      
      <input type="number" class="form-control" name="team_id" placeholder="Id Team History" required=""/>
      <input type="text" class="form-control" name="team_name" placeholder="Team Name History" required=""/>
      <input type="text" class="form-control" name="team_founded" placeholder="Founded History" required="required"/>
      <input type="text" class="form-control" name="team_stadium" placeholder="Stadium History" required="required"/>
      <input type="text" class="form-control" name="team_status" placeholder="true[1] false[0] History" required="required"/>
        
      <input class="btn btn-primary btn-block" type="submit" value="Insert">  
      <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('inserthistory').style.display='none'" class="cancelbtn">Cancel</button>
  
    </div> 
    </form>
  </div>   
  
 <!-- Update Form -->
<div id="formupdate" class="wrapper modal">
   <form class="form-signin modal-content animate" action="formupdate" method="post">       
     <h2 class="form-signin-heading">Form Update</h2>
     
     <label for="cars">Choose Name</label>
		<select name="id" id="formselect" >
		<c:forEach var="team" items="${teams}">
		    <option value="${team.team_id}">${team.team_name}</option>
		</c:forEach>
		</select>
	 <input class="btn btn-primary btn-block" type="button" onclick="FillBilling()" value="Next">
	 <hr>
	<div id="div1" style="display: none; ;">
     <input id="aaa" type="text" class="form-control" name="team_name" placeholder="Team Name" required=""/>
     <input type="date" class="form-control" name="team_founded" placeholder="Founded" required="required"/>
     <input type="text" class="form-control" name="team_stadium" placeholder="Stadium" required="required"/>
     <input type="number" class="form-control" name="team_status" placeholder="true[1] false[0]" required="required"/>
       
     <input class="btn btn-primary btn-block" type="submit" value="Update">
    </div>
     <div class="container" style="background-color:#f1f1f1">
     <button type="button" onclick="document.getElementById('formupdate').style.display='none'" class="cancelbtn">Cancel</button>
   </div> 
   </form>
 </div>
  
  
  
      
<!-- BUTTON TABLE SHOW -->
			<div class="flex text-center">
				<div class="flex page-header">
				<!-- show all o Tean Controller -->
					<a href="./team/show">
					<button onclick="showTable('team')" class="custom-btn btn-2">
						Team</button>
					</a>
					<button onclick="showTable('player')" class="custom-btn btn-2">
						Player</button>
					
					<button onclick="showTable('match')" class="custom-btn btn-2">
						Match</button>
					
					<button onclick="showTable('history')" class="custom-btn btn-2">
						History</button>
				</div>
			</div>











			<div id="details"
				class="outline outline-2 outline-gray-500 w-full rounded-lg max-h-[60vh] overflow-y-auto mt-8 text-center text-4xl mt-3 mb-2 px-4 py-2">
<!-- TABLE TEAM -->
				<table id="team" class="w-full" >
					<tr class="border-b-2 border-gray-400/40">
						<th class="px-2 py-1 text-left font-medium">Team No.</th>
						<th class="px-2 py-1 text-left font-medium">Team Name</th>
						<th class="px-2 py-1 text-left font-medium">Team Founded</th>
						<th class="px-2 py-1 text-left font-medium">Team Stadium</th>
						<th class="px-2 py-1">&nbsp;</th>
						<th class="px-2 py-1">&nbsp;</th>
					</tr>
		
					<c:forEach var="row" items="${players}">
						<tr class="border-b-2 text-base border-dashed border-gray-400/40">

							<td class="px-3"><c:out value="${row.team_id}" /></td>
							<td class="px-1"><c:out value="${row.team_name}" /></td>
							<td class="px-1"><c:out value="${row.team_founded}" /></td>
							<td class="px-1"><c:out value="${row.team_stadium}" /></td>
							<td class="px-1">
								<button onclick="document.getElementById('editteam').style.display='block'" 
									data-type="edit" data-id="${row.team_id}">
								Edit
								</button>
							</td>
							<td class="px-1">
								<button data-type="delete" data-id="${row.team_id}">
									Delete</button>
							</td>
							<td><br></td>
						</tr>

					</c:forEach>
				</table>
				  <div id="editteam" class="wrapper modal">
				    <form class="form-signin modal-content animate">       
				      <h2 class="form-signin-heading">Update Team</h2>
				      
				      <input type="number" class="form-control" name="team_id" placeholder="Id Team" required=""/>
				      <input type="text" class="form-control" name="team_name" placeholder="Team Name" required=""/>
				      <input type="date" class="form-control" name="team_founded" placeholder="Founded" required="required"/>
				      <input type="text" class="form-control" name="team_stadium" placeholder="Stadium" required="required"/>
    
				      <input class="btn btn-primary btn-block" type="submit" value="Update">  
				      <div class="container" style="background-color:#f1f1f1">
				      <button type="button" onclick="document.getElementById('editteam').style.display='none'" class="cancelbtn">Cancel</button>
				  
				    </div> 
				    </form>
				  </div>
				
<!-- TABLE PLAYER -->
				<table id="player" class="hidden w-full">
					<tr class="border-b-2 border-gray-400/70">
						<th class="px-2 py-1 text-left font-medium">Player No.</th>
						<th class="px-2 py-1 text-left font-medium">Player Name</th>
						<th class="px-2 py-1 text-left font-medium">Player Birth</th>
						<th class="px-2 py-1 text-left font-medium">Player Status</th>
						<th class="px-2 py-1">&nbsp;</th>
						<th class="px-2 py-1">&nbsp;</th>
					</tr>
					<c:forEach var="row" items="${playeritems}">
						<tr class="border-b-2 text-base border-dashed border-gray-400/40">
							<td class="px-3"><c:out value="${row.player_id}" /></td>
							<td class="px-1"><c:out value="${row.player_name}" /></td>
							<td class="px-1"><c:out value="${row.player_birth}" /></td>
							<td class="px-1"><c:out value="${row.player_status}" /></td>
							<td class="px-1">
								<button onclick="document.getElementById('editplayer').style.display='block'"  data-type="edit" data-id="${row.player_id}">
									Edit</button>
							</td>
							<td class="px-1">
								<button data-type="delete" data-id="${row.player_id}">
									Delete</button>
							</td>
							<td><br></td>
						</tr>
					</c:forEach>

				</table>
				  <div id="editplayer" class="wrapper modal">
				    <form class="form-signin modal-content animate">       
				      <h2 class="form-signin-heading">Update Player</h2>
				      
				      <input type="text" class="form-control" name="player_name" placeholder="Player Name" required=""/>
					  <input type="date" class="form-control" name="player_birth" placeholder="Birth" required="required"/>
					  <input type="number" class="form-control" name="position_id" placeholder="Position Id" required="required"/>
					  <input type="number" class="form-control" name="team_id" placeholder="Team Id" required="required"/>
					  <input type="number" class="form-control" name="nation_id" placeholder="Nation Id" required="required"/>
       
				      <input class="btn btn-primary btn-block" type="submit" value="Update">  
				      <div class="container" style="background-color:#f1f1f1">
				      <button type="button" onclick="document.getElementById('editplayer').style.display='none'" class="cancelbtn">Cancel</button>
				  
				    </div> 
				    </form>
				  </div>
<!-- TABLE MATCH -->
				<table id="match" class="hidden w-full">
					<tr class="border-b-2 border-gray-400/70">
						<th class="px-2 py-1 text-left font-medium">Matches No.</th>
						<th class="px-2 py-1 text-left font-medium">Matches Date</th>
						<th class="px-2 py-1 text-left font-medium">Home Team</th>
						<th class="px-2 py-1 text-left font-medium">Away Team</th>
						<th class="px-2 py-1 text-left font-medium">Home Score</th>
						<th class="px-2 py-1 text-left font-medium">Away Score</th>
						<th class="px-2 py-1 text-left font-medium">Matches Status</th>
						<th class="px-2 py-1">&nbsp;</th>
						<th class="px-2 py-1">&nbsp;</th>
					</tr>
					<c:forEach var="row" items="${matches}">
						<tr class="border-b-2 text-base border-dashed border-gray-400/40">
							<td class="px-3"><c:out value="${row.matches_id}" /></td>
							<td class="px-1"><c:out value="${row.matches_date}" /></td>
							<td class="px-1"><c:out value="${row.home_team}" /></td>
							<td class="px-1"><c:out value="${row.away_team}" /></td>
							<td class="px-1"><c:out value="${row.home_score}" /></td>
							<td class="px-1"><c:out value="${row.away_score}" /></td>
							<td class="px-1"><c:out value="${row.matches_status}" /></td>
							<td class="px-1">
								<button onclick="document.getElementById('editmatch').style.display='block'" data-type="edit" data-id="${row.matches_id}">
									Edit</button>
							</td>
							<td class="px-1">
								<button data-type="delete" data-id="${row.matches_id}">
									Delete</button>
							</td>
							<td><br></td>
						</tr>
					</c:forEach>

				</table>
				<div id="editmatch" class="wrapper modal">
				    <form class="form-signin modal-content animate">       
				      <h2 class="form-signin-heading">Update Match</h2>
				      
				      <input type="number" class="form-control" name="matches_id" placeholder="Id Player" required=""/>
				      <input type="date" class="form-control" name="matches_date" placeholder="Player Name" required=""/>
				      <input type="number" class="form-control" name="home_team" placeholder="Birth" required="required"/>
				      
				      <input type="number" class="form-control" name="away_team" placeholder="Away Team" required=""/>
				      <input type="number" class="form-control" name="home_score" placeholder="Home Score" required=""/>
				      <input type="number" class="form-control" name="away_score" placeholder="Away Score" required="required"/>
         
				      <input class="btn btn-primary btn-block" type="submit" value="Update">  
				      <div class="container" style="background-color:#f1f1f1">
				      <button type="button" onclick="document.getElementById('editmatch').style.display='none'" class="cancelbtn">Cancel</button>
				  
				    </div> 
				    </form>
				  </div>
<!-- TABLE HISTORY PROCCESS NOT YET -->
				<table id="history" class="hidden w-full">
					<tr class="border-b-2 border-gray-400/70">
						<th class="px-2 py-1 text-left font-medium">Matches No.</th>
						<th class="px-2 py-1 text-left font-medium">matches_date</th>
						<th class="px-2 py-1 text-left font-medium">home_team</th>
						<th class="px-2 py-1 text-left font-medium">away_team</th>
						<th class="px-2 py-1 text-left font-medium">home_score</th>
						<th class="px-2 py-1 text-left font-medium">away_score</th>
						<th class="px-2 py-1 text-left font-medium">matches_status</th>
						<th class="px-2 py-1">&nbsp;</th>
						<th class="px-2 py-1">&nbsp;</th>
					</tr>
					<c:forEach var="row" items="${player.rows}">
						<tr class="border-b-2 text-base border-dashed border-gray-400/40">
							<td class="px-3"><c:out value="${row.matches_id}" /></td>
							<td class="px-1"><c:out value="${row.matches_date}" /></td>
							<td class="px-1"><c:out value="${row.home_team}" /></td>
							<td class="px-1"><c:out value="${row.away_team}" /></td>
							<td class="px-1"><c:out value="${row.home_score}" /></td>
							<td class="px-1"><c:out value="${row.away_score}" /></td>
							<td class="px-1"><c:out value="${row.matches_status}" /></td>
							<td class="px-1">
								<button onclick="document.getElementById('edithistory').style.display='block'" data-type="edit" data-id="${row.matches_id}">
									Edit</button>
							</td>
							<td class="px-1">
								<button data-type="delete" data-id="${row.matches_id}">
									Delete</button>
							</td>
							<td><br></td>
						</tr>
					</c:forEach>

				</table>
				<div id="edithistory" class="wrapper modal">
				    <form class="form-signin modal-content animate">       
				      <h2 class="form-signin-heading">Update History</h2>
				      
				      <input type="number" class="form-control" name="team_id" placeholder="Id Team History" required=""/>
				      <input type="text" class="form-control" name="team_name" placeholder="Team Name History" required=""/>
				      <input type="text" class="form-control" name="team_founded" placeholder="Founded History" required="required"/>
				      <input type="text" class="form-control" name="team_stadium" placeholder="Stadium History" required="required"/>
				      <input type="text" class="form-control" name="team_status" placeholder="true[1] false[0] History" required="required"/>
          
				      <input class="btn btn-primary btn-block" type="submit" value="Update">  
				      <div class="container" style="background-color:#f1f1f1">
				      <button type="button" onclick="document.getElementById('edithistory').style.display='none'" class="cancelbtn">Cancel</button>
				  
				    </div> 
				    </form>
				  </div>


			</div>

<!-- BUTTON INSERT -->

	<div class="dropdown py-3 ">
         <h4><strong>Insert Items</strong></h4>
        <div class="btn btn-2">
          <a onclick="document.getElementById('insertteam').style.display='block'" class="btn dropdown-item" href="#">Team</a>
          <a onclick="document.getElementById('insertplayer').style.display='block'" class="btn dropdown-item" href="#">Player</a>
          <a onclick="document.getElementById('insertmatch').style.display='block'" class="btn dropdown-item" href="#">Match</a>
          <a onclick="document.getElementById('inserthistory').style.display='block'" class="btn dropdown-item" href="#">History</a>
          
        </div>
        <h4><strong>Form Update</strong></h4>
        <div class="btn btn-2">
          <a onclick="document.getElementById('formupdate').style.display='block'" class="btn dropdown-item" >Form Update</a>
        </div>
      </div>		
		

		</div>
		

		
	</div>













	<footer class="footer" id="contact">
		<div class="container">
			<p class="text-muted">
			<p class="copyright text-muted small">
				Special thanks to <a
					href="https://getbootstrap.com/examples/sticky-footer-navbar/">Sticky Team FoodBoys.</a>
		</div>
	</footer>

<script>
document.getElementById('formupdate').addEventListener('click', FillBilling);
function FillBilling() {
	var show = document.getElementById('div1').style.display = "";
   	var displayname = document.getElementById('aaa');
    var sel = document.getElementById("formselect");
    var text= sel.options[sel.selectedIndex].text;
    
    displayname.value = text;
};

const tables = {
	    team: document.getElementById('team'),
	    player: document.getElementById('player'),
	    match: document.getElementById('match'),
	    history: document.getElementById('history')
	};
	
const buttons = {
	    team: tables.team.querySelectorAll('button'),
	    player: tables.player.querySelectorAll('button'),
	    match: tables.match.querySelectorAll('button'),
	    history: tables.history.querySelectorAll('button')
	};
	
function myFunction() {
  var input, filter, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  
  for (var table of Object.values(tables)){
  	tr = table.getElementsByTagName("tr");
  	for (i = 0; i < tr.length; i++) {
    	td = tr[i].getElementsByTagName("td")[0];
    	if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
    	}       
  	}
  }
}

function showTable(name) {
	
	for (var table of Object.values(tables))
	{		
		table.classList.add('hidden');
	}
	 tables[name].classList.remove('hidden');
	
	/*for (var table of Object.values(tables)){
		var documentEle = table;
		documentEle.classList.add('.hidden');
		} 		*/	
		
	
		//var documentEle = document.getElementById(name);
		//documentEle.classList.remove('hidden');
		
		
		//document.getElementById(tables[name]).classList.add('w-full');
		
		/*
		for (var table of Object.values(tables)){
		var documentEle = document.getElementById(table);
		documentEle.classList.add('hidden');
		}*/ 
		
	    	/*table.classList.add('hidden');
	      
	    tables[name].classList.remove('hidden');*/
	}
	



	for (var btn of buttons.team) {
	    if (btn.getAttribute("data-type") == "delete") {
	        const id = btn.getAttribute("data-id");
	        btn.addEventListener("click", () => {
	            window.location.href = "/del/team?id=" + id;
	        })
	    }
	}

	for (var btn of buttons.player) {
	    if (btn.getAttribute("data-type") == "delete") {
	        const id = btn.getAttribute("data-id");
	        btn.addEventListener("click", () => {
	            window.location.href = "/del/player?id=" + id;
	        })
	    }
	}

	for (var btn of buttons.match) {
	    if (btn.getAttribute("data-type") == "delete") {
	        const id = btn.getAttribute("data-id");
	        btn.addEventListener("click", () => {
	            window.location.href = "/del/match?id=" + id;
	        })
	    }
	}

	for (var btn of buttons.history) {
	    if (btn.getAttribute("data-type") == "delete") {
	        const id = btn.getAttribute("data-id");
	        btn.addEventListener("click", () => {
	            window.location.href = "/del/history?id=" + id;
	        })
	    }
	}

	

</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- 
	<h1>${title }</h1>
	
	<h2>${thay }</h2>
	
	<div class="container">
		<div>
			<form action="${pageContext.request.contextPath}/f/upload" method="post"
			enctype="multipart/form-data">
				<label>Upload file :</label> <input type="file" name="profileImage"/>
				<input type="submit" value="upload"/>
			</form>
		</div>
		<div>
			<p>Can client access uploaded file</p>
			<p>@see servlet-context.xml</p>
			<img alt="alt" src="${pageContext.request.contextPath}${url}">
		</div>
	</div>
 -->
</body>
</html>