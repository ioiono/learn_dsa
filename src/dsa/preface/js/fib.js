const fib = n => n < 2 ? n : fib(n - 1) + fib(n - 2);
const fibDP = n => {
  let f = 0;
  let g = 1;
  while (n-- > 0) [g, f] = [g + f, g];
  return f;
};
// console.log(fibDP(40));
// console.log(fib(40));

const f = n => {
  if (n < 3) return n;
  else       return f(n - 1) + 2 * f(n - 2) + 3 * f(n - 3);
};

const fDP = n => {
  let f = 0;
  let g = 1;
  let h = 2;
  while (n-- > 0) {
    [h, g, f] = [h + 2 * g + 3 * f, h, g];
  }
  return f;
};
console.log(f(0));
console.log(f(1));
console.log(f(2));
console.log(f(3));
console.log(f(4));
console.log('==================');
console.log(fDP(0));
console.log(fDP(1));
console.log(fDP(2));
console.log(fDP(3));
console.log(fDP(4));