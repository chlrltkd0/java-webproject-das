import About from './components/About.vue'
import RequestDelivery from './components/RequestDelivery.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import DeliveryList from './components/DeliveryList.vue'
import Delivery from './components/Delivery.vue'
import AdminChart from './components/AdminChart.vue'
import DeliveryMap from './components/DeliveryMap.vue'
import BBS from './components/BBS.vue'
import Board from './components/Board.vue'
import WriteBoard from './components/WriteBoard.vue'
import TestPage from './components/TestPage.vue'
import ManageMember from './components/ManageMember.vue'
import Manage from './components/Manage.vue'
import MyPage from './components/MyPage.vue'

export default [
  {path: '/', component : About},
  {path: '/requestdelivery', component : RequestDelivery},
  {path: '/login', component : Login},
  {path: '/register', component : Register},
  {path: '/deliverylist', component : DeliveryList},
  {path: '/delivery', component : Delivery},
  {path: '/adminchart', component : AdminChart},
  {path: '/deliverymap', component : DeliveryMap},
  {path: '/bbs', component : BBS},
  {path: '/board', component : Board},
  {path: '/writeboard', component : WriteBoard},
  {path: '/testpage', component : TestPage},
  {path: '/managemember', component : ManageMember},
  {path: '/manage', component : Manage},
  {path: '/mypage', component : MyPage}
]
