const swap = (arr, i, j) => {
  [arr[i], arr[j]] = [arr[j], arr[i]];
};

const partition = (arr, start, end) => {
  const pivot = arr[end];

  let pIndex = start;
  for (let i = start; i < end; i++) {
    if (arr[i] < pivot) {
      swap(arr, pIndex++, i);
    }
  }
  swap(arr, pIndex, end);
  return pIndex;
};

const sort = (arr, l, r) => {
  if (l >= r) return;

  const pIndex = partition(arr, l, r);
  sort(arr, l, pIndex - 1);
  sort(arr, pIndex + 1, r);

};

const quickSort = arr => {
  sort(arr, 0, arr.length - 1);
};


const genArr = (n = 10000, max = 10000) => {
  return [...Array(n)].map(x => ~~(max * (Math.random())));
};

const a = genArr();
const test = arr => {
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < arr[i - 1]) {
      return false;
    }
  }
  return true;
};

console.log(test(a));
quickSort(a);
console.log(test(a));

