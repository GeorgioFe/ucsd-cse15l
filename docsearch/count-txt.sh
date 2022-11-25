set -e
find $1/ -type f -name "*.txt" > grep-results.txt
wc grep-results.txt