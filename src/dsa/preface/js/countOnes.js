const countOnes = n => {
  let sum = 0;
  while (n > 0) {
    sum += (1 & n);
    n >>= 1;
  }
  return sum;
};

const countOnes2 = n => {
  let sum = 0;
  while (n !== 0) {
    n &= (n - 1);
    sum++;
  }
  return sum;
};

console.log(countOnes(441));
console.log(countOnes2(441));