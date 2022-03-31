![image](https://user-images.githubusercontent.com/85056996/161123879-ea6622dd-8328-4626-9b9a-dd04ed95ffaf.png)

<h2>More datails</h2>
3 branches were created:
<p>1. master (default)</p>
<p>2. new_branch</p>
<p>3. third_branch</p>

<p>Each branch created its own commits, after which branches №2 and №3 were merged with branch №1. At the same time, branch №3 was pushed to a remote repository and there I used a pull request, after which branch №3 was merged with branch №1. After that, master branch has been pulled into the local repository.</p>


<h3>I used the following commands</h3>
<p>1.git merge new_branch</p>
<p>2.git checkout -b new_branch</p>
<p>3.git brabnch -f branch HEAD~2 (test)</p>
<p>1.git log</p>
<p>1.git push -f origin master (git push)</p>
<p>etc.</p>
