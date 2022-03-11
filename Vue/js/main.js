 const app = new Vue({
     el:"#app",
     data:{
         books:
         [{name:"java",date:"2021-01-01",money:100,sum:1},
         {name:"mysql",date:"2021-01-02",money:203,sum:2},
         {name:"linux",date:"2021-01-03",money:542,sum:3},
         {name:"mybatis",date:"2021-01-04",money:16,sum:4},],
         isShow: true,
     },
     methods:{
         Subtraction(index){
             if(this.books[index].sum == 0){
                 this.isShow = false;
             }
             this.books[index].sum --;
         },
         addition(index){
             this.books[index].sum ++;
         },
         removeClick(index){
             this.books.splice(index,1);
         }
     },
     computed:{
        booksMonryCount(){
           // let count = 0;
            // 方式一:
            // for (let i = 0; i <this.books.length ; i++) {
            //     count += this.books[i].sum * this.books[i].money
            // }
            // 方式二:
            // for (let i in this.books) {
            //     count += this.books[i].sum * this.books[i].money
            // }
            // 方式三:
            // for (let book of this.books){
            //     count += book.sum * book.money
            // }
            // return count;

            // 方式四:
            return this.books.reduce(function (value ,book){
                return value + book.money* book.sum;
            },0);
        }
     },
     filters:{
         moneyFormatting(money){
             return "$"+money.toFixed(2);
         }
     }

 })

