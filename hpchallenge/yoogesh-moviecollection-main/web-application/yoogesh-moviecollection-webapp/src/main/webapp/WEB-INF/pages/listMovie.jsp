<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script>
	jQuery(document).ready(function($){		
    	$('#movieListTblId').dataTable();
	});
</script>

<%@ include file="../../header.jsp"%>
<body>

	<div>
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Movie List</h4></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="movieListTblId" 
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<tr>
								<th>SN.</th>
								<th>Title</th>
								<th>Format</th>
								<th>Length</th>
								<th>Year</th>
								<th>Rating</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="listValue" items="${listMovie}" varStatus="cnt">
								<tr>
									<td>${cnt.count}</td>
									<td>${listValue.videoTitle}</td>
									<td>${listValue.videoFormat}</td>
									<td>${listValue.videoLengthMin} Min ${listValue.videoLengthMin} Sec</td>
									<td>${listValue.videoReleaseYear}</td>
									<td>${listValue.videoRating}</td>
									<td>
										<div class="btn-group">
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