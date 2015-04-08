<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Yoogesh - Movie Manager</title>

    <!-- Bootstrap -->    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>

    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
					<li><a href="#">Movies<span class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">About</a></li>
				</ul>
			</div>			
		</div>		
	</nav>

	<div>

		<div class="panel panel-default">
			<div class="panel-heading">Panel heading</div>
			<div class="panel-body">
				<!-- <div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<img src="..." alt="..."/>
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div> -->
				
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>								
								<th>Format</th>
								<th>Length</th>
								<th>Year</th>
								<th>Rating</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:if test="${not empty listMovie}">							
								<c:forEach var="listValue" items="${listMovie}">
									<tr>
										<td>${listValue.videoId}</td>
										<td>${listValue.videoTitle}</td>
										<td>${listValue.videoFormat}</td>
										<td>${listValue.videoLength}</td>
										<td>${listValue.videoReleaseYear}</td>
										<td>${listValue.videoRating}</td>
										<td>
											<div class="btn-group" role="group" aria-label="...">
												<button type="button" class="btn btn-default" 
												onclick="location.href='${listValue.videoId}/editMovie.htm'">Edit</button>
												
												<button type="button" class="btn btn-default" 
													    onclick="location.href='${listValue.videoId}/deleteMovie.htm'">Delete</button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<button type="button" class="btn btn-default">Add</button>
				</div>
			</div>
		</div>
	</div>

    
    <nav class="navbar navbar-default navbar-fixed-bottom">
  		<div class="container" align="center">Copyright @2015   Yoogesh Sharma.</div>
	</nav>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>    
    
    
  </body>
</html>