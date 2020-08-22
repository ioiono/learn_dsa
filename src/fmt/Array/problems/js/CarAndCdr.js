/**
 * This problem was asked by Jane Street.
 *
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 *
 * Given this implementation of cons:
 *
 * def cons(a, b):
 *     def pair(f):
 *         return f(a, b)
 *     return pair
 * Implement car and cdr.
 */

const cons = (a, b) => fn => fn(a, b);

const car = f => f((a, b) => a);

const car1 = (a, b) => a;

const cdr = f => f((a, b) => b);

const cdr1 = (a, b) => b;

const l = car(cons(3, 4)); // 3
const r = cdr(cons(3, 4)); // 4

// emm in fact car is just a wrapper for car1

console.log(cons(3, 4)(car1)); // 3
console.log(cons(3, 4)(cdr1)); // 4


