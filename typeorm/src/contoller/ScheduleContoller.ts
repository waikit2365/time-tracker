import {getRepository, MoreThan, LessThan, MoreThanOrEqual, Equal} from "typeorm";
import {NextFunction, Request, Response} from "express";
import {Schedule} from "../entity/Schedule";

export class ScheduleController {

    private scheduleRepository = getRepository(Schedule);

    async all(request: Request, response: Response, next: NextFunction) {
        return this.scheduleRepository.find()
    }

    async ScheduleDaily(request: Request, response: Response, next: NextFunction) {
        let todayDate = new Date()
        todayDate.setHours(0)
        todayDate.setMinutes(0)
        todayDate.setSeconds(0)
        todayDate.setMilliseconds(0)
        return this.scheduleRepository.find({
            where: {
                start_at: MoreThanOrEqual(todayDate)
            }
        });
    }

    async ScheduleCategory(request: Request, response: Response, next: NextFunction) {
        return this.scheduleRepository.find({
            where: {
                category_id: Equal(request.params.category_id)
            }
        });
    }

    async addSchedule(request: Request, response: Response, next: NextFunction) {
        let Schedule = await this.scheduleRepository.save({
            description: request.body.description,
            category_id: request.body.category_id,
            start_at: request.body.start_at,
            end_at: request.body.end_at,
            plan_actual: request.body.plan_actual,
        })
        Schedule.createdAt = new Date()
        this.scheduleRepository.save(Schedule)

        console.log(Schedule)
        response.send("Insert new schedule record")

    }

    async updateSchedule(request: Request, response: Response, next: NextFunction){
        let Schedule = await this.scheduleRepository.findOne(request.params.Id)
        Schedule.description = request.body.description,
        // Schedule.category_id = request.body.category_id,
        Schedule.startAt = request.body.start_at,
        Schedule.endAt = request.body.end_at
        return this.scheduleRepository.save(Schedule)
    }

    async removeSchedule(request: Request, response: Response, next: NextFunction) {
        let Schedule = await this.scheduleRepository.findOne(request.body.id);
        await this.scheduleRepository.remove(Schedule);
        response.send("Delete successfully")
    }
}