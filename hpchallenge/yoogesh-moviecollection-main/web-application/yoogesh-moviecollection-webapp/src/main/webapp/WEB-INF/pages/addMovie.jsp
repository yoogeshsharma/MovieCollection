<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html lang="en">
  <%@ include file="../../header.jsp" %>
  <body>
	<div>
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Add Movie</h4></div>
			<div class="panel-body">


				<form:form commandName="movie" cssStyle="form-horizontal" role="form">
					<div class="form-group">
						<label for="videoTitle" class="col-md-2"> Title :</label>
						<div class="col-md-10">
							<form:input path="videoTitle" cssClass="form-control" maxlength="50" placeholder="Movie Title"/>							
						</div>
					</div>

					<div class="form-group">
						<label for="format" class="col-md-2"> Format : </label>
						<div class="col-md-10">
							<form:select path="videoFormat" multiple="false" cssClass="form-control">
								<form:option value=""></form:option>
								<form:options items="${mvFormatList}"/>
							</form:select>							
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2"> Length :</label>
						<div class="col-md-5">
							<form:input path="videoLengthMin" cssClass="form-control" placeholder="Min"/>
						</div>
						<div class="col-md-5">
							<form:input path="videoLengthSec" cssClass="form-control" placeholder="Sec"/>
						</div>
					</div>

					<div class="form-group">
						<label for="videoReleaseYear" class="col-md-2">Release Year :</label>
						<div class="col-md-10">
							<form:select path="videoReleaseYear" multiple="false" cssClass="form-control">								
								<form:options items="${mvReleaseYearList}"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">Rating :</label>
					    <div class="col-sm-10">
							<c:forEach var="rating" items="${mvRatingList}">
								<label class="radio-inline">								
									<form:radiobutton path="videoRating" value="${rating}" label="${rating}" 
											cssClass="form-control"/>
								</label>
							</c:forEach>
					    </div>
					</div>

					<div class="checkbox">
						<div class="col-md-2"></div>
						<div class="col-md-10">&nbsp;</div>
					</div>

					<div class="form-group">
						<div class="col-md-2"></div>
						<div class="col-md-1">							
							<button type="submit" class="btn btn-primary">ADD</button>							
						</div>
						<div class="col-md-9">
							<button type="button" class="btn btn-primary">BACK</button>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>
	
	<%@ include file="../../footer.html" %>
	
  </body>
</html>