import {ScheduleController} from "./contoller/ScheduleContoller";

export const Routes = [{
    method: "get",
    route: "/schedule/daily",
    controller: ScheduleController,
    action: "ScheduleDaily"
}, {
    method: "get",
    route: "/schedule/:category_id",
    controller: ScheduleController,
    action: "ScheduleCategory"
}, {
    method: "post",
    route: "/schedule",
    controller: ScheduleController,
    action: "addSchedule"
}, {
    method: "put",
    route: "/schedule/:id",
    controller: ScheduleController,
    action: "updateSchedule"
}, {
    method: "delete",
    route: "/schedule/:id",
    controller: ScheduleController,
    action: "removeSchedule"
}]

