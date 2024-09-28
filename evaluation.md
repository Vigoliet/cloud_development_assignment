# Evaluation of the project


## 3 things to improve
### GitHub 
While GitHub was smooth for the most part, it was an issue with the pipeline. Since I wanted to add a repository that was under "Distansakademin" I could only make CodeBuild work if I generated a PAT token, however this step does not work on CodePipeline step.
Hence, I had to create 2 separate identically repositories that I push the code to.
### Https
Https is a requirement for Cognito to work, but this proves difficult if you don't have a domain, since you have to generate a fake certificate (in this case on the EC2 instance).
While this works if I enter https://13.60.185.16 - it still proves buggy with cookies of redirect and if you don't enter http you get redirected to nginx instead after logging in.
### Pipeline  
Currently, there's a bug that pushes 2 builds due to the token used in the build step. This is fine, but it's not optimal. And if I had more time, I would've changed this.

## 3 things that went well

### Environment variables
Locally and during both Codebuild, Codepipeline and EC2 the environment variables worked as expected.
At first this was a struggle, since you can't use frameworks like dotenv due to the build not working, but the solution was to use the AWS console to add the environment variables.
And use configurations locally. This also allows me to expose the application.yml file, without being worried of leaking sensitive information - Since they're stored elsewhere.


### GitHub and Git
While I in previous steps mentioned GitHub as a step to improve, I still feel like it went smooth for the most part. When I push the code and version my project, it's for most part flawless.

### Overall code structure
While the whole flow might be messy, I still feel that code wise it's cleanly made and not messy. Well-structured and was easy to troubleshoot when something went wrong as a consequence.


## How I would have done this project differently
After some research I would most likely use Elastic Beanstalk or just Docker in the first place. This current project is taking some shortcuts at certain point, which makes the end product much less robust.
And since I learned how to handle the environment variables through AWS services I would create all sources with ENV first, so I don't have to remove tracking of the yml file.
