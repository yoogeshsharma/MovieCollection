<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../header.html"%>
<body>

	<div>
		<div class="panel panel-primary">
			<div class="panel-heading">Panel heading</div>
			<div class="panel-body">
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
											<button type="button" class="btn btn-primary"
												onclick="location.href='${listValue.videoId}/editMovie.htm'">Edit</button>

											<button type="button" class="btn btn-primary"
												onclick="location.href='${listValue.videoId}/deleteMovie.htm'">Delete</button>
										</div>
									</td>
								</tr>
								</c:forEach>
						</tbody>
					</table>
					<button type="button" class="btn btn-primary"
						onclick="location.href='addMovie.htm'">Add</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../../footer.html"%>

</body>
</html>