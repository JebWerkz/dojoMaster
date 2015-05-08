<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Aspen Martial Arts DojoMaster</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 20em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills nav-justified">
            <li role="presentation" class="active">
                <a href="#">Home</a>
            </li>
            <li role="presentation">
                <a href="#">For Students</a>
            </li>
            <li role="presentation">
                <a href="#">For Parents</a>
            </li>
            <li role="presentation">
                <a href="#">For Instructors</a>
            </li>
        </ul>
        
        <div id="status" role="complementary">
			<h1>School News</h1>
			<ul>
                <li><a href="#">Upcoming tournament at FMAC</a></li>
                <li><a href="#">Demo @ CelebrAsian</a></li>
                <li><a href="#">Skills exams next week!</a></li>
            </ul>
            <h1>Resources</h1>
			<ul>
			    <li><a href="#">Gold Team Manual</a></li>
                <li><a href="#">5 Quick Tips: Classroom Protocol</a></li>
                <li><a href="#">Blue Team Entrance Exam Prep</a></li>
            </ul>
            <h1>Quote of the Day</h1>
            <blockquote>Do not break your opponent.  Break his will to fight you.</blockquote>
            <p>Michael</p>
            <h1>Master Jack's Reminder</h1>
            <p>With the summer months upon us, make sure to keep well hydrated throughout the day.  By the time you feel thirsty, it's already too late!</p>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to Aspen Martial Arts DojoMaster</h1>
			<p>
                Use the links above to navigate the site and check on your progress, study for a team exam, or browse our resource library.  As always, if you have any questions, feel free to email them to the.masters@aspenmartialarts.com, or ask an instructor next time you're in class!
            </p>
		</div>
	</body>
</html>
