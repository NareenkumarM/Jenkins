// Declarative pipelines must be enclosed with a "pipeline" directive.
pipeline {
    // This line is required for declarative pipelines. Just keep it here.
    agent any

    // This section contains environment variables which are available for use in the
    // pipeline's stages.
    environment {
	    region = "us-east-1"
        docker_repo_uri = ""
		task_def_arn = ""
        cluster = ""
        exec_role_arn = ""
    }
    
    // Here you can define one or more stages for your pipeline.
    // Each stage can execute one or more steps.
    stages {
        // This is a stage.
        stage('Example') {
            steps {
                // This is a step of type "echo". It doesn't do much, only prints some text.
                echo 'This is a Jenkins Project from Nareenkumar Manohar'
                // For a list of all the supported steps, take a look at
                // https://jenkins.io/doc/pipeline/steps/ .
            }
        }
	    stage('Searching'){
		    steps{
			    echo 'This is the next sample for the project'
		    }
	    }
	    stage('Test'){
		    steps{
			    sh 'javac app.java'
			    echo 'Java Application Runned Successfully'
		    }
	    }
	  
    }
}
