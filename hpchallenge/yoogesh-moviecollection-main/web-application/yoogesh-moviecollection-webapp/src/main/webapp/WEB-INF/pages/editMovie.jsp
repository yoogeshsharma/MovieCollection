<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html lang="en">
  <%@ include file="../../header.html" %>
  <body>
	<div>
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Edit Movie</h4></div>
			<div class="panel-body">


				<form:form method="POST">
					<div class="form-group">
						<label for="title" class="col-md-2"> Title :</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="title" min="1" max="50" maxlength="50"
								value="${mvdetail.videoTitle}"
								placeholder="Movie Title">
						</div>
					</div>

					<div class="form-group">
						<label for="format" class="col-md-2"> Format : </label>
						<div class="col-md-10">
							
							<select name="format" id="format" class="form-control">
								<option>--Please Select--</option>
								<option selected="selected">DVD</option>
								<option>Streaming</option>
								<option>VHS</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2"> Length :</label>
						<div class="col-md-5">
							<input type="text" class="form-control"
								value="${mvdetail.videoLengthMin}" 
								id="lengthMin" placeholder="Min">							
						</div>
						<div class="col-md-5">
							<input type="text" class="form-control"
								value="${mvdetail.videoLengthSec}" 
								id="lengthSec" placeholder="Sec">
						</div>
					</div>

					<div class="form-group">
						<label for="movieReleaseYear" class="col-md-2">Release Year :</label>
						<div class="col-md-10">
							<input type="text" class="form-control"
								value="${mvdetail.videoReleaseYear}" 
								id="movieReleaseYear" placeholder="Release Year">
						</div>
					</div>

					<div class="form-group">
						<label for="rating" class="col-md-2"> Rating : </label>
						<div class="col-md-10">
							<select name="rating" id="rating" class="form-control">
								<option>--Please Select--</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>

					<div class="checkbox">
						<div class="col-md-2"></div>
						<div class="col-md-10">&nbsp;</div>
					</div>

					<div class="form-group">
						<div class="col-md-2"></div>
						<div class="col-md-1">
							<button type="submit" class="btn btn-primary">EDIT</button>
						</div>
						<div class="col-md-9">
							<button type="submit" class="btn btn-primary">BACK</button>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>
	
	<%@ include file="../../footer.html" %>
	
  </body>
</html>