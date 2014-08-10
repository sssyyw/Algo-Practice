string L[K];
int lines = 0;
while (file.good()){
	getline(file, L[lines % K]);
        ++lines;
}

//if less than K lines were read, print them all
int start, count;
if (lines < K){
    start = 0;
    count = lines;
} else {
    start = lines % K;
    count = K;
}

for (int i = 0; i < count; ++i){
    cout << L[(start + 1) % K] << endl;
}
