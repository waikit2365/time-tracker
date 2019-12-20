import {Entity, PrimaryGeneratedColumn, Column, Timestamp, OneToMany, ManyToOne, JoinColumn} from "typeorm";
import { Category } from "./Category";

@Entity()
export class Schedule {

    @PrimaryGeneratedColumn()
    id: number;

    @ManyToOne(type => Schedule)
    @JoinColumn({ name: 'category_id' })
    schedule: Schedule

    @Column()
    description: string;

    @Column("datetime", { name: 'start_at' })
    startAt;

    @Column("datetime", { name: 'end_at' })
    endAt;

    @Column("datetime", { name: 'created_at' })
    createdAt;

    @Column("datetime", { name: 'modify_at' })
    modifyAt;

    @Column({ name: 'plan_actual' })
    planActual: string;
}
