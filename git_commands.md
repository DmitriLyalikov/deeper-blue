Terminal for PR

# go to the following site to clone repo. only needs to be done once.
# https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository

# If you have not worked on the repo in a while and had pushed everything to github already, make sure to update your branch
git pull origin main

# to make a new branch
git checkout -b [name of branch]
# to swtich branches
git checkout [name of branch]

To make the pr
# do it in order
git add --all
git commit -m " comment here about changes made "
# PUSH FROM YOU OWN BRANCH - i.e. " git push origin jason " 
git push origin [name of branch]

# Once you have completed the following about, go to github and hit compare and review

# In comments type  "close #issue-number" and assign reviewers if not assigned already.

