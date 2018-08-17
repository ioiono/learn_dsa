const transpose = A => A[0].map((val, idx) => A.map(row => row[idx]));

const arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
console.log(transpose(arr));